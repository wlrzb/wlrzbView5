package gdecid.render;

import gdecid.visual.VisualItem;

public interface RendererFactory {
	
	public Renderer getRenderer(VisualItem item);
	
}
