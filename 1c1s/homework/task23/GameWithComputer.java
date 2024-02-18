import java.util.Random;

public class GameWithComputer extends AbstractGame{

	public GameWithComputer(int maxHP) {
		super(maxHP);
		Random rand = new Random();
		int botType = rand.nextInt(2); // выбор между стратегией бота случаный
		if (botType == 0) {
			p2 = new DummyBot(maxHP);
		} else {
			p2 = new RandomBot(maxHP);
		}
	}

	public void gameProcess() {
		Bot bot = (Bot) p2;
		while (p1.alive() && bot.alive()) {
			System.out.println(p1 + " is going to kick " +
					bot + " with force: ");
			int f = in.nextInt();
			while (!(1 <= f && f <= 10)) {
				System.out.println("Некорректный ввод");
				f = in.nextInt();
			}
			boolean result = p1.kick(bot, f);

			Log.logResult(result, bot);

			// next

			result = bot.kick(p1);
			Log.logResult(result, p1);

		}

	}

}