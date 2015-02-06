package com.wowapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wowapi.model.MyHttpUtil;
import com.wowapi.model.Player;
import com.wowapi.model.PlayerAchievement;
import com.wowapi.model.playerachievement.AchievementResponse;

public class Check {

	private static Logger logger = Logger.getLogger(Check.class);

	Map<String, List<Player>> playerList = new HashMap<>();
	@SuppressWarnings("serial")
	Map<Long, String> achievementList = new HashMap<Long, String>() {{
		put(8966l, "Mythic: Gruul");
		put(8967l, "Mythic: Oregorger");
		put(8968l, "Mythic: Hans'gar and Franzok");
		put(8956l, "Mythic: Beastlord Darmac");
		put(8932l, "Mythic: Flamebender Ka'graz");	
		put(8969l, "Mythic: Operator Thogar");
		put(8970l, "Mythic: Blast Furnace");
		put(8971l, "Mythic: Kromog");
		put(8972l, "Mythic: Iron Maidens");
		put(8973l, "Mythic: Blackhand's Crucible");


		//test
		put(8965l, "Mythic: Imperator's Fall");
	}};

	public Check () {

		playerList.put("Paragon", Arrays.asList(
				new Player ("Verestrasz", "lightnings-blade", "eu"),
				new Player ("Lappe", "lightnings-blade", "eu"),
				new Player ("Alzu", "lightnings-blade", "eu"),
				new Player ("Riksu", "lightnings-blade", "eu"),
				new Player ("Devai", "lightnings-blade", "eu"),
				new Player ("Luumu", "lightnings-blade", "eu"),
				new Player ("Zelliiz", "lightnings-blade", "eu"),
				new Player ("Verdishamonk", "lightnings-blade", "eu"),
				new Player ("Fraggoji", "lightnings-blade", "eu"),
				new Player ("Seijta", "lightnings-blade", "eu")
				));

		playerList.put("Method", Arrays.asList(
				new Player ("Sco", "twisting-nether", "eu"),
				new Player ("Kreps", "twisting-nether", "eu"),
				new Player ("Raziee", "twisting-nether", "eu"),
				new Player ("Drquyn", "twisting-nether", "eu"),
				new Player ("Perfecto", "twisting-nether", "eu"),
				new Player ("Smootie", "twisting-nether", "eu"),
				new Player ("Twold", "twisting-nether", "eu"),
				new Player ("Rogerbrown", "twisting-nether", "eu"),
				new Player ("Apko", "twisting-nether", "eu")
				));

		playerList.put("Blood Legion", Arrays.asList(
				new Player ("Riggimon", "illidan", "us"),
				new Player ("Zachlock", "illidan", "us"),
				new Player ("Absalom", "illidan", "us"),
				new Player ("Perran", "illidan", "us"),
				new Player ("Shuttletwo", "illidan", "us"),
				new Player ("Ahdehll", "illidan", "us"),
				new Player ("Kutaa", "illidan", "us"),
				new Player ("Madison", "illidan", "us"),
				new Player ("Scholtes", "illidan", "us")
				));

		playerList.put("Exorsus", Arrays.asList(
				new Player ("Домек", "ревущий-фьорд", "eu"),
				new Player ("Моранах", "ревущий-фьорд", "eu"),
				new Player ("Сэу", "ревущий-фьорд", "eu"),
				new Player ("Штырьпожоще", "ревущий-фьорд", "eu"),
				new Player ("Споз", "ревущий-фьорд", "eu"),
				new Player ("Вейхем", "ревущий-фьорд", "eu"),
				new Player ("Дейси", "ревущий-фьорд", "eu"),
				new Player ("Ёмпос", "ревущий-фьорд", "eu"),
				new Player ("Шаморан", "ревущий-фьорд", "eu"),
				new Player ("Надоубивать", "ревущий-фьорд", "eu")
				));

		playerList.put("Style War", Arrays.asList(
				new Player ("西瓦修斯", "thousand-needles", "cn"),
				new Player ("玖伍肆叁", "thousand-needles", "cn"),
				new Player ("米米雕", "thousand-needles", "cn"),
				new Player ("荣姣姣", "thousand-needles", "cn"),
				new Player ("斯塔斯之猎", "thousand-needles", "cn"),
				new Player ("劣质枪法", "thousand-needles", "cn"),
				new Player ("汉宫易", "thousand-needles", "cn"),
				new Player ("斷風賢", "thousand-needles", "cn"),
				new Player ("偶吧欧巴", "thousand-needles", "cn")
				));
		
		playerList.put("Ascension", Arrays.asList(
				new Player ("Kovak", "barthilas", "us"),
				new Player ("Pasteryy", "barthilas", "us"),
				new Player ("Marrsyy", "barthilas", "us"),
				new Player ("Plsmonies", "barthilas", "us"),
				new Player ("Luice", "barthilas", "us"),
				new Player ("Korvakqt", "barthilas", "us"),
				new Player ("Sashafierce", "barthilas", "us"),
				new Player ("Loregasm", "barthilas", "us"),
				new Player ("Anthrall", "barthilas", "us"),
				new Player ("Xariaz", "barthilas", "us")
				));
	}

	private List<PlayerAchievement> getPlayerAchievements(Player player) {
		List<PlayerAchievement> achievements = new ArrayList<>();
		MyHttpUtil httpUtil = new MyHttpUtil();
		String webResponse = httpUtil.get(String.format("http://%s/api/wow/character/%s/%s?fields=achievements",
				mapRegionHost(player.getRegion()),
				player.getRealm(),
				player.getName()));

		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson =  gsonBuilder.create();
		AchievementResponse response = gson.fromJson(webResponse, AchievementResponse.class);   

		for (Long achievementId: response.getAchievements().getAchievementsCompleted()) {
			try {
				achievements.add(new PlayerAchievement(
						achievementId, 
						response.getAchievements().getAchievementsCompletedTimestamp().get( response.getAchievements().getAchievementsCompleted().indexOf(achievementId))));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return achievements;
	}

	private String mapRegionHost(String region) {
		String result;
		switch (region) {
		case "cn":
			result = "www.battlenet.com.cn";	       
			break;
		default:
			result = region + ".battle.net";
			break;
		}
		return result;
	}

	public void run() {
		for (String guildName: playerList.keySet()) {
			for (Player player: playerList.get(guildName)) {
				try {
					List<PlayerAchievement> achives = getPlayerAchievements(player);				
					for (Long bossId: achievementList.keySet()) {					
						achives.stream().filter(c -> c.getAchievementId().equals(bossId)).findAny().ifPresent(						
								a -> logger.info(String.format("%s of \"%s\" has achieved \"%s(%d)\" at %s",
										player,
										guildName,
										achievementList.get(bossId),
										bossId,
										a.getUTCtime()))
								);
					}	
				}
				catch (Exception e) {
					logger.error("Error in loading player", e);
					e.printStackTrace();
				}
			}
		}

	}

}
