package org.myextension;

import java.util.ArrayList;
import java.util.List;


public class SearchService
{
	public List<String> search(final String text)
	{
		final List<String> result = new ArrayList<String>();
		result.add(text);
		result.add("Hello");
		result.add("Cockpit NG");
		result.add("Developer");

		return result;
	}
}