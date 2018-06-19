package org.alostale.issues.generics;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestGenerics {
	@Test
	public void thisShouldCompile() {
		List<String> myList = Arrays.asList("a", "b", "c");
		assertThat("List doesn't contain unexpected elements", myList,
				not(anyOf(hasItem("d"), hasItem("e"), hasItem("f"))));
	}
}
