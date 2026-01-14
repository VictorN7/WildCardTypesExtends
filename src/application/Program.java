package application;

import java.util.ArrayList;
import java.util.List;
import entity.Circle;
import entity.Rectangle;
import entity.Shape;

public class Program {

	public static void main(String[] args) {
		
		List<Shape> listShape = new ArrayList<>();
		listShape.add(new Rectangle(2.5,4.6));
		listShape.add(new Circle(5.9));
		
		List<Circle> listCircle = new ArrayList<>();
		listCircle.add(new Circle(5.9));
		
		List<Rectangle> listRectangle = new ArrayList<>();
		listRectangle.add(new Rectangle(2.5,4.6));

		// Não posso colocar list de subtipos no método calcShapes, pois o compilador informa a necessidade de casting
		System.out.println("Total value: "+ calcShapes(listShape));
		System.out.println("Total value: "+ calcTypeShapes(listCircle));
		System.out.println("Total value: "+ calcTypeShapes(listRectangle));
		System.out.println("Total value: "+ calcTypeShapes(listShape));
	}

	// Se colocar apenas o ? nesses metodos, não é compilado o código, pois ele informa que podem vim qualquer tipo de list
	// Ex: Se vier um tipo object com strings, o laço for each não entraria, pois ela se trata de calculos
	// Por esses e outros casos existe a segurança de tipos, para que não ocorra do código quebrar
	
	// Recebe lista de shape apenas
	public static double calcShapes(List<Shape> list){
		
		// list.add(new Circle(5.9)); Esse caso funcionaria, pois list pode adicionar subtipos de Shape 
		
		double sum= 0; 
		
		for (Shape sha: list) {
			sum += sha.area();
		}
		return sum ; 
	}
	
	// Recebe lista de objetos do tipo shape e subclasses que herdam dela
	public static double calcTypeShapes(List<? extends Shape> list){
		
		// list.add(new Circle(5.9)); 
		// Apresenta erro pois o list pode ser um shape,circle ou rectangle e isso afeta a segurança de tipos. 
		// ? extends Shapes não especifica exatamente qual o tipo está vindo. 
		// Se vir um List do tipo Rectangle, ao tentar adicionar o Circle, o código quebraria. 
		
		double sum= 0; 
		
		for (Shape sha: list) {
			sum += sha.area();
		}
		return sum ; 
	}
	
}