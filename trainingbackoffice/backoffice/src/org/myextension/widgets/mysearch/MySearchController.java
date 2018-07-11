package org.myextension.widgets.mysearch;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.myextension.SearchService;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Image;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.ext.Selectable;

import com.hybris.cockpitng.annotations.ViewEvent;
import com.hybris.cockpitng.util.DefaultWidgetController;

import demo.getting_started.Car;


public class MySearchController extends DefaultWidgetController
{

	@Wire
	private Listbox carListbox;
	@WireVariable
	private SearchService searchService;
	@Wire
	private Textbox keywordBox;
	@Wire
	private Label modelLabel;
	@Wire
	private Label makeLabel;
	@Wire
	private Label priceLabel;
	@Wire
	private Label descriptionLabel;
	@Wire
	private Image previewImage;
	@Wire
	private Component detailBox;
	@Wire
	private Component createBox;
	@Wire
	private Textbox part_id;
	@Wire
	private Textbox source_code;
	@Wire
	private Textbox source_part_id;
	@Wire
	private Textbox price;


	//@Listen("onClick = #searchButton")
	@ViewEvent(componentID = "searchButton", eventName = Events.ON_CLICK)
	public void search()
	{
		final String keyword = keywordBox.getValue();
		final List<Car> result = search(keyword);
		carListbox.setModel(new ListModelList<Car>(result));
	}

	//@Listen("onSelect = #carListbox")
	@ViewEvent(componentID = "carListbox", eventName = Events.ON_SELECT)
	public void showDetail()
	{
		detailBox.setVisible(true);

		final Set<Car> selection = ((Selectable<Car>) carListbox.getModel()).getSelection();
		if (selection != null && !selection.isEmpty())
		{
			final Car selected = selection.iterator().next();
			modelLabel.setValue(selected.getModel());
			makeLabel.setValue(selected.getMake());

		}
	}


	@ViewEvent(componentID = "createPrice", eventName = Events.ON_CLICK)
	public void getForm()
	{
		createBox.setVisible(true);

	}

	@ViewEvent(componentID = "savePrice", eventName = Events.ON_CLICK)
	public void createPrice()
	{
		System.out.println(part_id.getText() + "erwrwwt" + source_part_id.getText() + "aaaa");
	}







	//@ViewEvent(componentID = "searchBtn", eventName = Events.ON_CLICK)
	/*
	 * public void doSearch() throws InterruptedException { //final List<String> result =
	 * searchService.search(searchInput.getText()); //Messagebox.show(result.get(0)); //final CarService carService = new
	 * CarServiceImpl(); //final List<Car> carListbox = carService.findAll(); final List<Car> result1 = new
	 * ArrayList<Car>(); final Car car1 = new Car(); car1.setModel("test1"); final Car car2 = new Car();
	 * car2.setModel("test2"); result1.add(car1); result1.add(car2); final Car car3 = new Car(); car3.setModel("test3");
	 * final Car car4 = new Car(); car4.setModel("test4"); result1.add(car3); result1.add(car4); final Car car5 = new
	 * Car(); car5.setModel("test5"); final Car car6 = new Car(); car6.setModel("test6"); result1.add(car5);
	 * result1.add(car6); final Car car7 = new Car(); car7.setModel("test7"); final Car car8 = new Car();
	 * car8.setModel("test8"); result1.add(car7); result1.add(car8);
	 *
	 *
	 * getCarListbox().setModel(new ListModelList<Car>(result1)); getCarListbox().renderAll(); }
	 */

	public List<Car> search(final String keyword)
	{
		final List<Car> carList = new LinkedList<Car>();
		final Car car1 = new Car();
		car1.setModel("test1");
		final Car car2 = new Car();
		car2.setModel("test2");
		carList.add(car1);
		carList.add(car2);
		final Car car3 = new Car();
		car3.setModel("test3");
		final Car car4 = new Car();
		car4.setModel("test4");
		carList.add(car3);
		carList.add(car4);
		final Car car5 = new Car();
		car5.setModel("test5");
		final Car car6 = new Car();
		car6.setModel("test6");
		carList.add(car5);
		carList.add(car6);
		final Car car7 = new Car();
		car7.setModel("test7");
		final Car car8 = new Car();
		car8.setModel("test8");
		final Car car9 = new Car();
		car9.setModel("test9");
		carList.add(car7);
		carList.add(car8);


		//getCarListbox().setModel(new ListModelList<Car>(result1));

		List<Car> result = new LinkedList<Car>();
		if (keyword == null || "".equals(keyword))
		{
			result = carList;
		}
		else
		{
			for (final Car c : carList)
			{
				if (c.getModel().toLowerCase().contains(keyword.toLowerCase()))
				{
					result.add(c);
				}
			}
		}
		return result;
	}

	/**
	 * @return the carListbox
	 */
	public Listbox getCarListbox()
	{
		return carListbox;
	}

	/**
	 * @param carListbox
	 *           the carListbox to set
	 */
	public void setCarListbox(final Listbox carListbox)
	{
		this.carListbox = carListbox;
	}



}
