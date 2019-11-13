package Map;

public enum Terrain{
	WALKABLE, BLOCKED;

	public static Terrain getTerrain(int i) {
		
		switch(i) {
			
			case 1:
				return Terrain.WALKABLE;
			case 2:
				return Terrain.BLOCKED;
			default:
				return Terrain.BLOCKED;
		
		}
		
	}
}
