package gwt.material.design.client.ui;

import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTMLPanel;

public class MaterialButton extends FocusPanel {

	private HTMLPanel panel;

	private String text = "";
	private String type = "";
	private String color = "";
	private String icon = "";
	private String iconPosition = "right";
	private String size = "";
	private String display ="";
	private String textColor="";
	
	public MaterialButton() {

	}

	public String getIcon() {
		return icon;
	}

	/**
	 * Browse the icon list http://materializecss.com/icons.html for more icon
	 * set
	 * 
	 * @param icon
	 */
	public void setIcon(String icon) {
		this.icon = icon;
		generateButton();

	}

	public String getText() {
		return text;
	}

	/**
	 * Set the button text
	 * 
	 * @param text
	 */
	public void setText(String text) {
		this.text = text;
		generateButton();
	}

	public String getType() {
		return type;
	}

	/**
	 * Types: 1. floating 2. flat
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
		generateButton();
	}

	public String getColor() {
		return color;
	}

	/**
	 * Browse the color palette for the Material Designs
	 * http://materializecss.com/color.html
	 * 
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
		generateButton();

	}

	public String getIconPosition() {
		return iconPosition;
	}

	/**
	 * Icon Positions: 1. left 2. right
	 * 
	 * @param iconPosition
	 */
	public void setIconPosition(String iconPosition) {
		this.iconPosition = iconPosition;
		generateButton();
	}

	public String getSize() {
		return size;
	}

	/**
	 * Button Sizes: 1. large 2. small
	 * 
	 * @param size
	 */
	public void setSize(String size) {
		this.size = size;
		generateButton();
	}
	
	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
		this.getElement().setAttribute("style", "display: " + display + ";");
		generateButton();
	}

	public String getTextColor() {
		return textColor;
	}

	public void setTextColor(String textColor) {
		this.textColor = textColor;
		generateButton();
	}
	
	private void generateButton() {
		this.clear();
		panel = new HTMLPanel(generateHTML());
		this.add(panel);
	}
	
	private String generateHTML() {
		
		String html = "";
		if (type.equals("flat")) {
			html += "<a type='submit' name='action' class='waves-effect gwtMaterialDesign ";
			if ( color != "" ) {
				html += "waves-" + color;
			}
		}else if(type.equals("floating")){
			html += "<button type='submit' name='action' class='btn btn-large waves-effect waves-light gwtMaterialDesign ";
			if ( color != "" ) {
				html += color;
			}
		} 
		else {
			html += "<button type='submit' name='action' class='btn waves-effect waves-light gwtMaterialDesign ";
			if ( color != "" ) {
				html += color;
			}
		}
		
		
		
		if ( type != "" ) {
			html += " btn-" + type;
		}
		
		if ( size != "" ) {
			html += " btn-" + size;
		}
		
		html += "'"; // ending for the class attribute
		
		
		if ( textColor != "" ) {
			html += textColor;
		}
		
		html += "'"; //end of style
		
		
		html += ">"; // ending for the button tag
		
		if ( icon != "" ) {
			html += "<i class='" + icon + " " + iconPosition + "'></i>";
		}
		
		html += text;
		if(type.equals("flat")) {
			html += "</a>";
		} else {
			html += "</button>";;
		}	
		
		return html;
	}
}