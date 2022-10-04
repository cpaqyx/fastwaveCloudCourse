package fastwave.cloud.order.service;

import fastwave.cloud.demo.fastwavelibcommon.R;

import java.util.Map;

public interface OrderService {

    R createOrder(Map<String, Object> params) throws Exception;
}
