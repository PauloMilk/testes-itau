package br.com.pauloleitecosta.communicationms.amqp;

public interface AmqpProducer<T> {
	
	void producer(T t);	

}
