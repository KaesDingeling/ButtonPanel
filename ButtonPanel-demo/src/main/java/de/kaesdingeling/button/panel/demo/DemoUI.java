package de.kaesdingeling.button.panel.demo;

import javax.servlet.annotation.WebServlet;

import com.github.appreciated.material.MaterialTheme;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import de.kaesdingeling.button.panel.ButtonPanel;

@Theme("demo")
@Title("ButtonPanel Add-on Demo")
public class DemoUI extends UI {
	private static final long serialVersionUID = -8364046713574555488L;

	@WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = true, ui = DemoUI.class)
    public static class Servlet extends VaadinServlet {
		private static final long serialVersionUID = 5879871642389623710L;
    }

    @Override
    protected void init(VaadinRequest request) {
    	VerticalLayout rootLayout = new VerticalLayout();
    	
    	ButtonPanel buttonPanel = new ButtonPanel("Test", VaadinIcons.DASHBOARD);
    	
    	buttonPanel.setDefaultAddButtonStyle(MaterialTheme.BUTTON_FLAT);

    	buttonPanel.addButton(new Button(VaadinIcons.EDIT));
    	buttonPanel.addButton(new Button(VaadinIcons.CLOCK));
    	
    	buttonPanel.setHeight(300, Unit.PIXELS);
    	buttonPanel.setWidth(500, Unit.PIXELS);
    	
    	rootLayout.setSizeFull();
    	
    	Panel testPanel = new Panel();
    	
    	buttonPanel.setContent(testPanel);
    	
    	rootLayout.addComponent(buttonPanel);
    	
    	rootLayout.setComponentAlignment(buttonPanel, Alignment.MIDDLE_CENTER);
    	
        setContent(rootLayout);
    }
}