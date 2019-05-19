import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.modelmapper.ModelMapper;

public class MappingTest {

	@Test
	public void mapping_simpleMapping_ok() {
		ModelMapper modelMapper = new ModelMapper();

		Name name = new Name();
		name.firstName = "Uwe";
		name.lastName = "M.";
		
		Customer customer = new Customer();
		customer.name = name;
		
		Order order = new Order();
		order.customer = customer;
		
		OrderDto orderDto = modelMapper.map(order, OrderDto.class);
		
		Assertions.assertThat(order.customer.name.firstName).isEqualTo(orderDto.customerFirstName);
	}
}
