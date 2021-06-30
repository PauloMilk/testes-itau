package br.com.pauloleitecosta.paymentms.amqp;

public interface AmqpProducer<T> {
	
	void producer(T t);	

}
