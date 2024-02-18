public class GameWithHuman extends AbstractGame{

	public GameWithHuman(int maxHP) {
			super(maxHP);
			System.out.println("Choose type of 2nd Player");
			System.out.println("1. Player");
			System.out.println("2. Healer");
			int choice = in.nextInt();
			in.nextLine();
			if (choice != 2) { // если игрок выбрал НЕ HealerPlayer то ему дадим обычного
				System.out.println("Введите имя игрока 2");
				p2 = new Player(in.nextLine(), maxHP);
			} else {
				System.out.println("Введите имя игрока 2");
				p2 = new HealerPlayer(in.nextLine(), maxHP, 20);
			}
	}

	public void gameProcess() {
		Player kicker = (Player)p1;
		Player enemy = (Player)p2;
		while (p1.alive() && p2.alive()) {
			System.out.println(kicker + " is going to kick " + 
								enemy + " with force: ");
			int f = in.nextInt();
			while (!(1 <= f && f <= 10)) {
				System.out.println("Некорректный ввод");
				f = in.nextInt();
			}
			boolean result = kicker.kick(enemy, f);
			if (result) {
				System.out.println("Success, " + enemy.getName() + "'s hp is " + enemy.getHp() + ".");
			} else {
				System.out.println("Missed");
			}
			
			if (kicker instanceof HealerPlayer) {
				System.out.println(((HealerPlayer) kicker).getName() + ", выберите количество HP для восстановления, сейчас доступно "
									+ ((HealerPlayer) kicker).getHealPoints());
				int heal = in.nextInt();
				if (heal <= ((HealerPlayer) kicker).getHealPoints()) {
					((HealerPlayer) kicker).heal(heal);
					System.out.println(((HealerPlayer) kicker).getName() + " восстановил " + heal + " HP.");
				} else {
					System.out.println("Лечение не удалось");
				}
			}
			
			Player swap = kicker;
			kicker = enemy;
			enemy = swap;
		}	
	}

}