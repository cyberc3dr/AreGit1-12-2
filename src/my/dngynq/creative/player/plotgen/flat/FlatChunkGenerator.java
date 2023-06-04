package my.dngynq.creative.player.plotgen.flat;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;

public class FlatChunkGenerator extends ChunkGenerator {
	  @Override
	  public ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, BiomeGrid biome) {
	      ChunkData chunk = createChunkData(world);
	      
	      for(int X = -3; X < 3; X++) {
	          for(int Z = -3; Z < 3; Z++) {
	      if(chunkX == X && chunkZ == Z){
	          
	          for(int Xb = 0; Xb < 16; Xb++) {
	              for(int Zb = 0; Zb < 16; Zb++) {
	                  chunk.setBlock(Xb, 0, Zb, Material.BEDROCK);
	                  chunk.setBlock(Xb, 1, Zb, Material.DIRT);
	                  chunk.setBlock(Xb, 2, Zb, Material.DIRT);
	                  chunk.setBlock(Xb, 3, Zb, Material.GRASS);
	              }
	          }
	          
	          
	      }
	          }
	      }
	    return chunk;
	  }
	}
