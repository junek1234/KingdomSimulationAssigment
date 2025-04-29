
import orange.MyArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTest {

  private MyArrayList<String> list;

  @BeforeEach
  public void setUp() {
    list = new MyArrayList<>();
  }



  /*
   *  Testing that a single element added to an empty list increases size to 1
   *  Using list.add("A") followed by size()
   *  Z (Zero), O (One), S (Simple), I (Interface)
   */
  @Test
  public void addElementToEmptyList_increasesSize() {
    list.add("A");
    assertEquals(1, list.size());
  }

  /*
   *  Testing that elements added at the end preserve insertion order
   *  Adding "A" and then "B", verifying both with get()
   *  M (Many), S (Simple), I (Interface)
   */
  @Test
  public void addElementToEnd_preservesOrder() {
    list.add("A");
    list.add("B");
    assertEquals("A", list.get(0));
    assertEquals("B", list.get(1));
  }



  /*
   *  Testing insertion at index 0
   *  Adding "B", then inserting "A" at index 0, checking order
   *  B (Boundary), S (Simple), I (Interface)
   */
  @Test
  public void addElementAtIndex_zeroIndex_addsAtBeginning() {
    list.add("B");
    list.add(0, "A");
    assertEquals("A", list.get(0));
  }

  /*
   *  Testing insertion at a middle index
   *  Adding "A", "C", then inserting "B" at index 1, using toString() for verification
   *  M (Many), B (Boundary), S (Simple), I (Interface)
   */
  @Test
  public void addElementAtIndex_middleIndex_insertsCorrectly() {
    list.add("A");
    list.add("C");
    list.add(1, "B");
    assertEquals("{A, B, C}", list.toString());
  }

  /*
   *  Testing exception when inserting at invalid index
   *  Attempting to insert at index 1 in an empty list
   *  E (Exception), S (Simple), I (Interface)
   */
  @Test
  public void addElementAtInvalidIndex_throwsException() {
    assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, "X"));
  }



  /*
   *  Testing get() on valid index
   *  Adding one element and retrieving it
   *  O (One), S (Simple), I (Interface)
   */
  @Test
  public void getValidIndex_returnsCorrectElement() {
    list.add("A");
    assertEquals("A", list.get(0));
  }

  /*
   *  Testing get() with invalid index throws exception
   *  Attempting to access element at index 0 in an empty list
   *  Z (Zero), E (Exception), S (Simple), I (Interface)
   */
  @Test
  public void getInvalidIndex_throwsException() {
    assertThrows(IllegalStateException.class, () -> list.get(0));
  }



  /*
   *  Testing set() to replace element at valid index
   *  Setting index 0 from "A" to "B" after adding one element
   *  O (One), S (Simple), I (Interface)
   */
  @Test
  public void setValidIndex_replacesElement() {
    list.add("A");
    list.set(0, "B");
    assertEquals("B", list.get(0));
  }

  /*
   *  Testing set() at invalid index throws exception
   *  Calling set(0, "X") on empty list
   *  Z (Zero), E (Exception), S (Simple), I (Interface)
   */
  @Test
  public void setInvalidIndex_throwsException() {
    assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, "X"));
  }



  /*
   *  Testing that remove(index) returns the removed element
   *  Adding one item and removing it by index
   *  O (One), S (Simple), I (Interface)
   */
  @Test
  public void removeAtIndex_returnsRemovedElement() {
    list.add("A");
    String removed = list.remove(0);
    assertEquals("A", removed);
  }

  /*
   *  Testing remove(index) on empty list throws exception
   *  Attempting to remove index 0 in empty list
   *  Z (Zero), E (Exception), S (Simple), I (Interface)
   */
  @Test
  public void removeAtInvalidIndex_throwsException() {
    assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
  }



  /*
   *  Testing that remove(element) returns the element removed
   *  Adding "A" and removing by value
   *  O (One), S (Simple), I (Interface)
   */
  @Test
  public void removeElement_existing_returnsElement() {
    list.add("A");
    String removed = list.remove("A");
    assertEquals("A", removed);
  }

  /*
   *  Testing remove(nonexistent element) throws exception
   *  Removing "A" from empty list
   *  Z (Zero), E (Exception), S (Simple), I (Interface)
   */
  @Test
  public void removeElement_notInList_throwsException() {
    assertThrows(IllegalStateException.class, () -> list.remove("A"));
  }



  /*
   *  Testing contains() returns true for existing element
   *  Adding "A" and checking contains("A")
   *  O (One), I (Interface), S (Simple)
   */
  @Test
  public void contains_existingElement_returnsTrue() {
    list.add("A");
    assertTrue(list.contains("A"));
  }

  /*
   *  Testing contains() returns false for missing element
   *  Checking contains("A") in empty list
   *  Z (Zero), I (Interface), S (Simple)
   */
  @Test
  public void contains_missingElement_returnsFalse() {
    assertFalse(list.contains("A"));
  }



  /*
   *  Testing indexOf() returns correct index for existing element
   *  Adding "A", checking indexOf("A")
   *  O (One), I (Interface), S (Simple)
   */
  @Test
  public void indexOf_existingElement_returnsIndex() {
    list.add("A");
    assertEquals(0, list.indexOf("A"));
  }

  /*
   *  Testing indexOf() returns -1 for missing element
   *  Checking indexOf("Z") in empty list
   *  Z (Zero), I (Interface), S (Simple)
   */
  @Test
  public void indexOf_missingElement_returnsMinusOne() {
    assertEquals(-1, list.indexOf("A"));
  }



  /*
   *  Testing isEmpty() returns true for new list
   *  Checking isEmpty() immediately after construction
   *  Z (Zero), I (Interface), S (Simple)
   */
  @Test
  public void isEmpty_newList_returnsTrue() {
    assertTrue(list.isEmpty());
  }

  /*
   *  Testing isEmpty() returns false after adding element
   *  Adding one element and checking isEmpty()
   *  O (One), I (Interface), S (Simple)
   */
  @Test
  public void isEmpty_nonEmptyList_returnsFalse() {
    list.add("A");
    assertFalse(list.isEmpty());
  }



  /*
   *  Testing isFull() always returns false
   *  Checking isFull() without elements
   *  I (Interface), S (Simple)
   */
  @Test
  public void isFull_withoutElements_alwaysReturnsFalse() {
    assertFalse(list.isFull());
  }

  /*
   *  Testing isFull() always returns false
   *  Checking isFull() with elements
   *  M (Many), I (Interface), S (Simple)
   */
  @Test
  public void isFull_withElements_alwaysReturnsFalse() {
    list.add("A");
    list.add("B");
    assertFalse(list.isFull());
  }



  /*
   *  Testing size() returns correct count
   *  Adding two elements and checking size()
   *  M (Many), S (Simple), I (Interface)
   */
  @Test
  public void size_returnsCorrectCount() {
    list.add("A");
    list.add("B");
    assertEquals(2, list.size());
  }



  /*
   *  Testing toString() for empty list
   *  Verifying that toString() returns "{}"
   *  Z (Zero), S (Simple), I (Interface)
   */
  @Test
  public void toString_emptyList_returnsEmptyBraces() {
    assertEquals("{}", list.toString());
  }

  /*
   *  Testing toString() for one element
   *  Adding "A" and checking toString() returns "{A}"
   *  O (One), S (Simple), I (Interface)
   */
  @Test
  public void toString_singleElement_returnsCorrectFormat() {
    list.add("A");
    assertEquals("{A}", list.toString());
  }

  /*
   *  Testing toString() for multiple elements
   *  Adding "A", "B", "C" and checking correct format
   *  M (Many), S (Simple), I (Interface)
   */
  @Test
  public void toString_multipleElements_returnsCorrectFormat() {
    list.add("A");
    list.add("B");
    list.add("C");
    assertEquals("{A, B, C}", list.toString());
  }
}
