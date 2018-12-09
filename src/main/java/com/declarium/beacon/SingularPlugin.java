package com.declarium.beacon;

import com.declarium.beacon.plugin.BeaconPlugin;

/**
 * An functionless implementation of a {@link BeaconPlugin}
 * allowing for Beacon to be used as a singular plugin,
 * which can be used as an alternative to requiring shading
 * of this resource for each and every plugin.
 *
 * @author Jay Carr
 * @version 1.0
 */
public final class SingularPlugin extends BeaconPlugin {
}