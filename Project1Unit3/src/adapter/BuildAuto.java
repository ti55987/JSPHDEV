/*
 * Author: Ti-Fen Pan
 * Andrew id: tpan
 * 
 * A connector between abstract class proxyAutomobile 
 * and interfaces : CreateAuto, UpdateAuto, FixAuto and SyncUpdateAuto
 * 
*/
package adapter;

import scale.SyncUpdateAuto;

public class BuildAuto 
		extends proxyAutomobile implements CreateAuto, UpdateAuto, FixAuto, SyncUpdateAuto{

}
