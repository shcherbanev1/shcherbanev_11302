import java.util.Scanner;

public class Game {
	// Game - обслуживающий класс - модуль для взаимодействия, поэтому сканер теперь тут корректен
	private Player p1, p2;
	private Scanner in = new Scanner(System.in); // чтобы лишний раз не инициализировать
	
	public Game(int maxHP) {
		// а кто за это отвечает? Как мы вводим данные? т.к здесь мы создаем Playerов то имя передаем здесь же
		System.out.println("Введите имя первого игрока");
		//in.nextLine();
		p1 = new Player(in.nextLine(), maxHP);
		//String name1 = in.nextLine();
		System.out.println("Введите имя второго игрока-лечителя");
		//String name2 = in.nextLine();
		p2 = new Player(in.nextLine(), maxHP);
	}
	
	public void go() {
		System.out.println("The battle has begun.");
		Player kicker = p1;
		Player enemy = p2;
		while (p1.alive() && p2.alive()) {
			System.out.println(kicker + " is going to kick " + 
								enemy + " with force: ");
			int f = in.nextInt(); // f - force
			while (!(1 <= f && f <= 10)) {
				System.out.println("Некорректный ввод");
				f = in.nextInt(); // f - force
			}
			boolean result = kicker.kick(enemy, f);
			if (result) {
				System.out.println("Success, " + enemy.getName() + "'s hp is " + enemy.getHp() + ".");
			} else {
				System.out.println("Missed");
			}
			Player swap = kicker;
			kicker = enemy;
			enemy = swap;
		}
		Player winner = p1.alive() ? p1: p2;
		System.out.println(winner.getName() + " won.");
		
	}
	
	public static void main(String [] args) {
		final int MAX_HP = (args.length == 1) ? Integer.parseInt(args[0]) : 100;
		Game g = new Game(MAX_HP);
		g.go();
		
	}
}