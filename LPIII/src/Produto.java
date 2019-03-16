import java.math.BigDecimal;

import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class Produto {
	private String name;
	private ProductType type;
	private BigDecimal price;
	private float qtty;
	private ImageView img = new ImageView(new Image(getClass().getResourceAsStream("images.png")));
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProductType getType() {
		return type;
	}
	public void setType(ProductType type) {
		this.type = type;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public float getQtty() {
		return qtty;
	}
	public void setQtty(float qtty) {
		this.qtty = qtty;
	}
	public ImageView getImg() {
		return img;
	}
	public void setImg(ImageView img) {
		this.img = img;
	}
	public Produto(String name, ProductType type, BigDecimal price, float qtty) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.qtty = qtty;
		
	}
	
	
	
	
	

}
