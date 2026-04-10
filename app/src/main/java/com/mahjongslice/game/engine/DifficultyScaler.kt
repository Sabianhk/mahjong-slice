package com.mahjongslice.game.engine

/**
 * Ramps difficulty over time. Provides current spawn interval,
 * max tiles, and base speed based on elapsed game time.
 */
class DifficultyScaler {

    private var gameStartTime = 0L

    fun reset() {
        gameStartTime = System.currentTimeMillis()
    }

    /** Seconds elapsed since game start */
    val elapsedSeconds: Float
        get() = if (gameStartTime == 0L) 0f
                else (System.currentTimeMillis() - gameStartTime) / 1000f

    /** Current difficulty tier (0-4) based on 30s intervals */
    val tier: Int
        get() = (elapsedSeconds / 30f).toInt().coerceIn(0, 4)

    // Slice variant: ~20% calmer than Slash — longer spawn intervals,
    // fewer tiles on screen, slower base speed. Same tier structure.

    /** Seconds between spawn groups */
    val spawnInterval: Float
        get() = when (tier) {
            0 -> 2.4f
            1 -> 1.8f
            2 -> 1.44f
            3 -> 1.08f
            else -> 0.72f
        }

    /** Maximum alive tiles on screen */
    val maxTiles: Int
        get() = when (tier) {
            0 -> 4
            1 -> 6
            2 -> 8
            3 -> 10
            else -> 12
        }

    /** Base speed in dp/s for tile movement */
    val baseSpeedDpPerSec: Float
        get() = when (tier) {
            0 -> 26f
            1 -> 34f
            2 -> 47f
            3 -> 60f
            else -> 72f
        }

    /** Speed variance range in dp/s */
    val speedVarianceDpPerSec: Float
        get() = when (tier) {
            0 -> 10f
            1 -> 15f
            2 -> 20f
            3 -> 25f
            else -> 30f
        }
}
