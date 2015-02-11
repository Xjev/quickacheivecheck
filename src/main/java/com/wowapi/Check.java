package com.wowapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
		//put(8965l, "Mythic: Imperator's Fall");
	}};

	public Check () {

				playerList.put("Paragon", Arrays.asList(
						new Player ("Verestrasz", "lightnings-blade", "eu"),
						new Player ("Lappe", "lightnings-blade", "eu"),
						new Player ("Alzu", "lightnings-blade", "eu"),
						new Player ("Seita", "lightnings-blade", "eu"),
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
						new Player ("Kuznam", "twisting-nether", "eu"),
						new Player ("Pottm", "twisting-nether", "eu"),
						new Player ("Lørgok", "twisting-nether", "eu"),
						new Player ("Landqvist", "twisting-nether", "eu"),
						new Player ("Kreps", "twisting-nether", "eu"),
						new Player ("Raziee", "twisting-nether", "eu"),
						new Player ("Drquyn", "twisting-nether", "eu"),
						new Player ("Perfecto", "twisting-nether", "eu"),
						new Player ("Smootie", "twisting-nether", "eu"),
						new Player ("Twold", "twisting-nether", "eu"),
						new Player ("Rogerbrown", "twisting-nether", "eu"),
						new Player ("Apko", "twisting-nether", "eu")
						));

				playerList.put("Exorsus", Arrays.asList(
						new Player ("Радостьмоя", "ревущий-фьорд", "eu"),
						new Player ("Бован", "ревущий-фьорд", "eu"),
						new Player ("Лайнаквин", "ревущий-фьорд", "eu"),						
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
				
				playerList.put("Ascendance", Arrays.asList(
						new Player ("Sennari", "draenor", "eu"),
						new Player ("Stash", "draenor", "eu"),
						new Player ("Orby", "draenor", "eu"),
						new Player ("Cherdin", "draenor", "eu"),
						new Player ("Rammo", "draenor", "eu"),
						new Player ("Eriya", "draenor", "eu"),
						new Player ("Rammoz", "draenor", "eu"),
						new Player ("Derwinn", "draenor", "eu"),
						new Player ("Pipex", "draenor", "eu"),
						new Player ("Camthalion", "draenor", "eu")
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
				
//				playerList.put("Blood Legion", Arrays.asList(
//				new Player ("Xyronic", "illidan", "us"),
//				new Player ("Slamino", "illidan", "us"),
//				new Player ("Itharn", "illidan", "us"),
//				new Player ("Zachx", "illidan", "us"),
//				new Player ("Jacktronic", "illidan", "us"),
//				new Player ("Monkfire", "illidan", "us"),
//				new Player ("Ahdehl", "illidan", "us"),
//				new Player ("Arold", "illidan", "us"),
//				new Player ("Hypnotized", "illidan", "us"),
//				new Player ("Brozooka", "illidan", "us"),
//				new Player ("Riggimon", "illidan", "us"),
//				new Player ("Zachlock", "illidan", "us"),
//				new Player ("Absalom", "illidan", "us"),
//				new Player ("Perran", "illidan", "us"),
//				new Player ("Shuttletwo", "illidan", "us"),
//				new Player ("Ahdehll", "illidan", "us"),
//				new Player ("Kutaa", "illidan", "us"),
//				new Player ("Madison", "illidan", "us"),
//				new Player ("Riggatron", "illidan", "us"),				
//				new Player ("Riggmonlee", "illidan", "us"),
//				new Player ("Monkfire", "illidan", "us"),
//				new Player ("Zoomkins", "illidan", "us"),
//				new Player ("Scholtes", "illidan", "us")
//				
//				));				

//		playerList.put("Ascension", Arrays.asList(				
//				new Player ("Korvak", "barthilas", "us"),
//				new Player ("Homodemon", "barthilas", "us"),
//				new Player ("Akirawr", "barthilas", "us"),
//				new Player ("Chuckles", "barthilas", "us"),
//				new Player ("Hahnsel", "barthilas", "us"),
//				new Player ("Hydro", "barthilas", "us"),
//				new Player ("Ofnu", "barthilas", "us"),
//				new Player ("Aokiie", "barthilas", "us"),
//				new Player ("Xariaz", "barthilas", "us"),
//				new Player ("Avath", "barthilas", "us"),
//				new Player ("Pasteryy", "barthilas", "us"),
//				new Player ("Marrsyy", "barthilas", "us")
//				));

//		playerList.put("Midwinter", Arrays.asList(
//				new Player ("Stenhaldi", "sargeras", "us"),
//				new Player ("Kennyloggins", "sargeras", "us"),
//				new Player ("Thebiggman", "sargeras", "us"),
//				new Player ("Affinity", "sargeras", "us"),
////				new Player ("Siory", "sargeras", "us"),	
////				new Player ("Dashima", "sargeras", "us"),
////				new Player ("Exoticflower", "sargeras", "us"),
////				new Player ("Kevsenior", "sargeras", "us"),
////				new Player ("Angz", "sargeras", "us"),
//				new Player ("Vigilate", "sargeras", "us"),
//				new Player ("Doxie", "sargeras", "us"),
//				new Player ("Slootbag", "sargeras", "us"),
//				new Player ("Jarinky", "sargeras", "us"),			
//				new Player ("Hesp", "sargeras", "us")
//				));
//		
//		playerList.put("Avast", Arrays.asList(
//				new Player ("Boozeyo", "jubeithos", "us"),
//				new Player ("Eroka", "jubeithos", "us"),
//				new Player ("Qariaa", "jubeithos", "us"),
//				new Player ("Alford", "jubeithos", "us"),
//				new Player ("Slicewrists", "jubeithos", "us"),
//				new Player ("Effectivedps", "jubeithos", "us"),
//				new Player ("Winclonex", "jubeithos", "us"),
//				new Player ("Palyo", "jubeithos", "us"),
//				new Player ("Disagreeable", "jubeithos", "us"),
//				new Player ("Crowded", "jubeithos", "us")
//				));

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
				logger.error("Error in finding achievement" + e.getMessage());
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

		while (true) {
			System.out.println("");
			for (String guildName: playerList.keySet()) {
				Set<Long> alreadyFoundAchives = new HashSet<>();
				for (Player player: playerList.get(guildName)) {
					try {
						List<PlayerAchievement> achives = getPlayerAchievements(player);				
						for (Long bossId: achievementList.keySet()) {
							if (alreadyFoundAchives.contains(bossId)) continue;
							achives.stream().filter(c -> c.getAchievementId().equals(bossId)).findAny().ifPresent(						
									a -> {
											logger.info(String.format("\"%s\" has achieved \"%s(%d)\" at %s, player: %s",											
												guildName,
												achievementList.get(bossId),
												bossId,
												a.getUTCtime(),
												player)); 
											alreadyFoundAchives.add(bossId);
										}											
									);
						}	
					}
					catch (Exception e) {
						logger.error("Error in loading player" + e.getMessage());						
					}
				}
			}
			try {
				logger.info("Sleeping...");
				Thread.sleep(1000*60*10);
			} catch (InterruptedException e) {
				logger.error(e);
			}		
		}
	}

}
