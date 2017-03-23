
package store.web;

/*
 * Copyright 2014 Bright Interactive, All Rights Reserved.
 * author: 周鸿清
 */

import org.apache.tiles.extras.complete.CompleteAutoloadTilesInitializer;
import org.apache.tiles.factory.AbstractTilesContainerFactory;
import org.apache.tiles.request.ApplicationContext;

/**
 * @author Bright Interactive
 */
public class SpringCompleteAutoloadTilesInitializer extends CompleteAutoloadTilesInitializer
{
	@Override
	protected AbstractTilesContainerFactory createContainerFactory(ApplicationContext context)
	{
		return new SpringCompleteAutoloadTilesContainerFactory();
	}
}
