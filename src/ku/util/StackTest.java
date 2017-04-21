package ku.util;

import static org.junit.Assert.*;

import java.awt.geom.IllegalPathStateException;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StackTest {

	private Stack stack;

	/** "Before" method is run before each test. */
	@Before
	public void setUp() {
		StackFactory.setStackType( 0 );
//		StackFactory.setStackType( 1 );
		stack = StackFactory.makeStack( 2 );
	}
	
	@Test
	public void newStackIsEmpty() {
		assertTrue( stack.isEmpty() );
		assertFalse( stack.isFull() );
		assertEquals( 0, stack.size() );
	}
	
	/** pop() should throw an exception if stack is empty */
	@Test( expected=java.util.EmptyStackException.class )
	public void testPopEmptyStack() {
		Assume.assumeTrue( stack.isEmpty() );
		stack.pop();
		// this is unnecessary. For documentation only.
		fail("Pop empty stack should throw exception");
	}
	
	@Test
	public void testPeek() {
		assertNull( stack.peek() );
		stack.push("a");
		assertEquals("a", stack.peek());
		stack.push("b");
		assertEquals("b", stack.peek());
		
	}
	
	@Test
	public void testStackFull() {
		stack.push("a");
		assertFalse(stack.isFull());
		stack.push("b");
		assertTrue(stack.isFull());
	}
	
	@Test
	public void testPopAllElement() {
		stack.push("a");
		stack.push("b");
		assertEquals( "b", stack.pop());
		assertEquals( "a", stack.pop());
	}
	
	@Test
	public void testSize() {
		stack.push("c");
		assertEquals( 2, stack.capacity() );
		stack.peek();
		assertEquals( 2, stack.capacity() );
		stack.pop();
		assertEquals( 2, stack.capacity() );
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPushNull() {
		stack.push( null );
	}
	
	@Test(expected = java.util.EmptyStackException.class)
	public void testPopStackEmpty() {
		assertTrue( stack.isEmpty() );
		stack.pop();
	}
	
	@Test(expected = IllegalStateException.class)
	public void testOverFlow() {
		stack.push( "hello" );
		stack.push( "hello" );
		stack.push( "hello" );
	}
	
	/** A method to create stacks, so we can change implementation */
	private Stack makeStack(int capacity) {
		// a dummy stack
		return new DummyStack(capacity);
	}

}
