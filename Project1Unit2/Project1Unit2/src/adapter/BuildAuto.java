/*
 * Author: Ti-Fen Pan
 * Andrew id: tpan
 * 
 * A connector between abstract class proxyAutomobile 
 * and interfaces : CreateAuto, UpdateAuto, FixAuto
 * 
*/
package adapter;

public class BuildAuto 
		extends proxyAutomobile implements CreateAuto, UpdateAuto, FixAuto{

}
