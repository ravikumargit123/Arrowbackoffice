package demo.getting_started.listbox;

import java.util.Set;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;

import demo.getting_started.Car;
import demo.getting_started.CarService;
import demo.getting_started.CarServiceImpl;


public class ListboxController extends SelectorComposer<Component>
{

	private static final long serialVersionUID = 1L;

	private final ListModel<Car> carsModel;

	@Wire
	private Window win;

	public ListboxController()
	{
		final CarService carService = new CarServiceImpl();
		carsModel = new ListModelList<Car>(carService.findAll());
		((ListModelList<Car>) carsModel).setMultiple(true);
	}

	public ListModel<Car> getCarsModel()
	{
		return carsModel;
	}

	@Listen("onSelect = listbox")
	public void updateMessage()
	{
		final Set<Car> selectedCars = ((ListModelList<Car>) carsModel).getSelection();
		final int size = selectedCars.size();

		showNotify(size > 0 ? size + " cars selected: " + selectedCars : "no car selected", win);
	}

	private void showNotify(final String msg, final Component ref)
	{
		Clients.showNotification(msg, "info", ref, "top_right", 2000);
	}
}
