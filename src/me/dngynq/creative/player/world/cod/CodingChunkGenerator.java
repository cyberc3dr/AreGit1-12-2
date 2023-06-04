/*    */ package me.dngynq.creative.player.world.cod;
/*    */ 
/*    */ import java.util.Random;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.generator.ChunkGenerator;
/*    */ 
/*    */ public class CodingChunkGenerator
/*    */   extends ChunkGenerator
/*    */ {
/*    */   public ChunkGenerator.ChunkData generateChunkData(World world, Random random, int chunkX, int chunkZ, ChunkGenerator.BiomeGrid biome) {
/* 12 */     ChunkGenerator.ChunkData chunk = createChunkData(world);
/*    */     
/* 14 */     for (int zX = -3; zX < 3; zX++) {
/* 15 */       for (int zZ = -3; zZ < 3; zZ++) {
/* 16 */         if (chunkX == zX && chunkZ == zZ)
/*    */         {
/* 18 */           for (int X = 0; X < 16; X++) {
/* 19 */             for (int Z = 0; Z < 16; Z++) {
/* 20 */               chunk.setBlock(X, 0, Z, Material.STAINED_GLASS);
/*    */             }
/*    */           } 
/*    */         }
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 28 */     return chunk;
/*    */   }
/*    */ }