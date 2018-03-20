package de.kaesdingeling.button.panel;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.server.Resource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

public class ButtonPanel extends Panel {
	private static final long serialVersionUID = -7923136609920304734L;
	
	protected static final String BUTTON_PANEL_STYLE = "buttonPanel";
	protected static final String BUTTON_PANEL_CONTENT_STYLE = "bPContent";
	protected static final String BUTTON_PANEL_BUTTONS_STYLE = "bPButtons";
	
	protected String buttonAddStyle = null;
	
	protected VerticalLayout content = new VerticalLayout();
	protected HorizontalLayout buttons = new HorizontalLayout();
	
	public ButtonPanel() {
		build(null, null);
	}
	
	public ButtonPanel(String caption) {
		build(caption, null);
	}
	
	public ButtonPanel(String caption, Resource icon) {
		build(caption, icon);
	}
	
	protected void build(String caption, Resource icon) {
		addStyleName(BUTTON_PANEL_STYLE);
		setCaption(caption);
		setIcon(icon);
		super.setContent(content);
		buttons.setSpacing(false);
		buttons.setMargin(false);
		buttons.setStyleName(BUTTON_PANEL_BUTTONS_STYLE);
		content.setSizeFull();
		content.setSpacing(false);
		content.setMargin(false);
		content.addComponentAsFirst(buttons);
	}
	
	@Override
	public void setStyleName(String style) {
		if (style.contains(BUTTON_PANEL_STYLE)) {
			style = style.replaceAll(BUTTON_PANEL_STYLE, "");
		}
		super.setStyleName(style);
	}
	
	@Override
	public void setContent(Component component) {
		if (content != null) {
			List<Component> toRemove = new ArrayList<Component>();
			
			for (int i = 0; i < content.getComponentCount(); i++) {
				if (!content.getComponent(i).equals(buttons)) {
					toRemove.add(content.getComponent(i));
				}
			}
			
			toRemove.forEach(c -> content.removeComponent(c));
			
			if (component != null) {
				component.addStyleName(BUTTON_PANEL_CONTENT_STYLE);
				component.setSizeFull();
			}
			
			content.addComponent(component);
		}
	}
	
	@Override
	public Component getContent() {
		if (content != null) {
			for (int i = 0; i < content.getComponentCount(); i++) {
				if (!content.getComponent(i).equals(buttons)) {
					return content.getComponent(i);
				}
			}
		}
		return null;
	}
	
	public ButtonPanel setDefaultAddButtonStyle(String buttonAddStyle) {
		this.buttonAddStyle = buttonAddStyle;
		return this;
	}
	
	public String getDefaultAddButtonStyle() {
		return buttonAddStyle;
	}
	
	public Button addButton(Button button) {
		if (buttonAddStyle != null && !buttonAddStyle.isEmpty()) {
			button.addStyleName(buttonAddStyle);
		}
		buttons.addComponent(button);
		return button;
	}
	
	public Button addButton(Button button, int index) {
		if (buttonAddStyle != null && !buttonAddStyle.isEmpty()) {
			button.addStyleName(buttonAddStyle);
		}
		buttons.addComponent(button, index);
		return button;
	}
	
	public Button expandButton(Button button, float ratio) {
		buttons.setExpandRatio(button, ratio);
		return button;
	}
	
	public ButtonPanel removeButton(Button button) {
		buttons.removeComponent(button);
		return this;
	}
	
	public ButtonPanel removeAllButton() {
		buttons.removeAllComponents();
		return this;
	}
	
	public List<Button> getButtons() {
		List<Button> buttonList = new ArrayList<Button>();
		
		for (int i = 0; i < buttons.getComponentCount(); i++) {
			if (buttons.getComponent(i) instanceof Button) {
				buttonList.add((Button) buttons.getComponent(i));
			}
		}
		
		return buttonList;
	}
}