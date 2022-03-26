package dev.orangeben.craftaddon;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class CAMain extends JavaPlugin {

	public static final Material[] BED_TYPES = {Material.BLACK_BED, Material.ORANGE_BED, Material.MAGENTA_BED, Material.YELLOW_BED, Material.LIME_BED, Material.PINK_BED, Material.GRAY_BED, Material.LIGHT_BLUE_BED, Material.LIGHT_GRAY_BED, Material.CYAN_BED, Material.PURPLE_BED, Material.BLUE_BED, Material.BROWN_BED, Material.GREEN_BED, Material.RED_BED, Material.WHITE_BED};
	
	// Fired when plugin is first enabled
    @Override
    public void onEnable() {
    	addRecipies(this);
    }
    
    // Fired when plugin is disabled
    @Override
    public void onDisable() {

    }
    
	public static void addRecipies(Plugin plugin) {

		// Shapless
		
		// Wool > String
		// Maybe should work with all colors? Only works with white for now
		ItemStack stringStack = new ItemStack(Material.STRING, 4);
		NamespacedKey stringKey = new NamespacedKey(plugin, "string");
		ShapelessRecipe stringRecipe = new ShapelessRecipe(stringKey, stringStack);
		stringRecipe.addIngredient(Material.WHITE_WOOL);
		Bukkit.addRecipe(stringRecipe);
		
		// Bookshelf > books
		ItemStack bookStack = new ItemStack(Material.BOOK, 3);
		NamespacedKey bookKey = new NamespacedKey(plugin, "books");
		ShapelessRecipe bookRecipe = new ShapelessRecipe(bookKey, bookStack);
		bookRecipe.addIngredient(Material.BOOKSHELF);
		Bukkit.addRecipe(bookRecipe);
		
		// Nametag
		ItemStack nametagStack = new ItemStack(Material.NAME_TAG, 1);
		NamespacedKey nametagKey = new NamespacedKey(plugin, "nametag");
		ShapelessRecipe nametagRecipe = new ShapelessRecipe(nametagKey, nametagStack);
		nametagRecipe.addIngredient(Material.STRING);
		nametagRecipe.addIngredient(Material.PAPER);
		Bukkit.addRecipe(nametagRecipe);
		
		// Grass block
		// Maybe should work with other seeds
		ItemStack grassblockStack = new ItemStack(Material.GRASS_BLOCK, 1);
		NamespacedKey grassblockKey = new NamespacedKey(plugin, "grassblock");
		ShapelessRecipe grassblockRecipe = new ShapelessRecipe(grassblockKey, grassblockStack);
		grassblockRecipe.addIngredient(Material.DIRT);
		grassblockRecipe.addIngredient(Material.WHEAT_SEEDS);
		grassblockRecipe.addIngredient(Material.BONE_MEAL);
		Bukkit.addRecipe(grassblockRecipe);
		
		// Bed bleaching
		for(Material bed :BED_TYPES) {
			ItemStack bedStack = new ItemStack(Material.WHITE_BED, 1);
			NamespacedKey bedKey = new NamespacedKey(plugin, bed.toString().substring(0, bed.toString().indexOf("_")) + "-bleached-bed");
			ShapelessRecipe bedRecipe = new ShapelessRecipe(bedKey, bedStack);
			bedRecipe.addIngredient(bed);
			bedRecipe.addIngredient(Material.WHITE_DYE);
			Bukkit.addRecipe(bedRecipe);
		}
		
		// Shaped
		// Saddle
		ItemStack saddleStack = new ItemStack(Material.SADDLE, 1);
		NamespacedKey saddleKey = new NamespacedKey(plugin, "saddle");
		ShapedRecipe saddleRecipe = new ShapedRecipe(saddleKey, saddleStack);
		saddleRecipe.shape("LLL", " L ", " I ");
		saddleRecipe.setIngredient('L', Material.LEATHER);
		saddleRecipe.setIngredient('I', Material.IRON_INGOT);
		Bukkit.addRecipe(saddleRecipe);
		
		// Elytra
		ItemStack elytraStack = new ItemStack(Material.ELYTRA);
		NamespacedKey elytraKey = new NamespacedKey(plugin, "saddle");
		ShapedRecipe elytraRecipe = new ShapedRecipe(elytraKey, elytraStack);
		elytraRecipe.shape(new String[]{"MLM", "MSM", "MdM"});
		elytraRecipe.setIngredient('F', Material.PHANTOM_MEMBRANE);
		elytraRecipe.setIngredient('L', Material.LEATHER);
		elytraRecipe.setIngredient('S', Material.SADDLE);
		elytraRecipe.setIngredient('D', Material.DIAMOND);
		Bukkit.addRecipe(elytraRecipe);

	}
}
