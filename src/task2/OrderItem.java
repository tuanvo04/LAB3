package task2;

public class OrderItem {
	private Product p;
	private int quality;

	public OrderItem(Product p, int quality) {
		super();
		this.p = p;
		this.quality = quality;
	}

	public int getQuality() {
		return quality;
	}

	public Product getP() {
		return p;
	}

	@Override
	public String toString() {

		return "p:" + p + " quality:" + quality;
	}

	public Product getProduct() {
		
		return p;
	}
}
