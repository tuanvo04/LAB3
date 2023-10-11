package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Order  {
	private OrderItem[] items;

	public Order(OrderItem[] items)  {
		super();
		this.items = items;
	}

	public OrderItem[] getItems() {
		return items;
	}

	public double cost() {

		double totalCost = 0.0;

		// Duyệt qua mảng các sản phẩm trong đơn hàng
		for (OrderItem item : items) {
			Product product = item.getP(); // Lấy thông tin sản phẩm
			int quantity = item.getQuality(); // Lấy số lượng sản phẩm

			// Tính tổng giá tiền của từng sản phẩm và cộng vào tổng giá tiền của đơn hàng
			totalCost += product.getPrice() * quantity;
		}

		return totalCost;
	}
	
	public boolean contains(Product p) {
	    int left = 0;
	    int right = items.length - 1;

	    while (left <= right) {
	        int mid = left + (right - left) / 2;
	        Product currentProduct = items[mid].getProduct();

	        // So sánh sản phẩm ở giữa với sản phẩm cần tìm
	        int comparisonResult = currentProduct.compareTo(p);

	        if (comparisonResult == 0) {
	            // Sản phẩm được tìm thấy
	            return true;
	        } else if (comparisonResult < 0) {
	            // Sản phẩm cần tìm nằm bên phải sản phẩm ở giữa
	            left = mid + 1;
	        } else {
	            // Sản phẩm cần tìm nằm bên trái sản phẩm ở giữa
	            right = mid - 1;
	        }
	    }

	    // Sản phẩm không được tìm thấy
	    return false;
	}
	 public void sortByPrice() {
	        Arrays.sort(items, new Comparator<OrderItem>() {
	        	@Override
	            public int compare(OrderItem item1, OrderItem item2) {
	                double price1 = item1.getProduct().getPrice();
	                double price2 = item2.getProduct().getPrice();

	                if (price1 < price2) {
	                    return -1;
	                } else if (price1 > price2) {
	                    return 1;
	                } else {
	                    return 0;
	                }
	            }
	        });
	 }
	 public Product[] filter(String type) {
		List<Product> product = new ArrayList<>();
		for(OrderItem item : items) {
			Product produc = item.getProduct();
			if(produc.getType().equals(type)) {
				product.add(produc);
			}
		}
		return product.toArray(new Product[0]);
		}
	 @Override
	public String toString() {
		
		return "items" + items;
	}

}