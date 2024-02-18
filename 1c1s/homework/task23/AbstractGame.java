import java.util.Scanner;

public abstract class AbstractGame {
	
	protected AbstractPlayer p1, p2;
	protected Scanner in = new Scanner(System.in); // чтобы лишний раз не инициализировать

	public AbstractGame(int maxHP) {
		System.out.println("Choose type of 1st Player");
		System.out.println("1. Player");
		System.out.println("2. Healer");
		int choice = in.nextInt();
		in.nextLine();
		if (choice != 2) { // если игрок выбрал НЕ HealerPlayer то ему дадим обычного
			System.out.println("Введите имя игрока 1");
			p1 = new Player(in.nextLine(), maxHP);
		} else {
			System.out.println("Введите имя игрока 1");
			p1 = new HealerPlayer(in.nextLine(), maxHP, 20);
		}
	}

	public void go() {
		start();
		gameProcess();
		end();
	}

	public abstract void gameProcess();

	public void start() {
		System.out.println("The battle has begun.");
	}

	public void end() {
		AbstractPlayer winner = p1.alive() ? p1: p2;
		System.out.println(winner.getName() + " won.");
	}
	
}