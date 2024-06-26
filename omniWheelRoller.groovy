import eu.mihosoft.vrl.v3d.parametrics.*;
import java.util.stream.Collectors;
import com.neuronrobotics.bowlerstudio.vitamins.Vitamins;
import eu.mihosoft.vrl.v3d.CSG;
import eu.mihosoft.vrl.v3d.Cube;
import eu.mihosoft.vrl.v3d.Cylinder
CSG generate(){
	String type= "omniWheelRoller"
	if(args==null)
		args=["4inch13Roller"]
	// The variable that stores the current size of this vitamin
	StringParameter size = new StringParameter(	type+" Default",args.get(0),Vitamins.listVitaminSizes(type))
	HashMap<String,Object> measurments = Vitamins.getConfiguration( type,size.getStrValue())

	def massCentroidXValue = measurments.massCentroidX
	def massCentroidYValue = measurments.massCentroidY
	def massCentroidZValue = measurments.massCentroidZ
	def massKgValue = measurments.massKg
	def priceValue = measurments.price
	def rollerHeightValue = measurments.rollerHeight
	def rollerthickDiameterValue = measurments.rollerthickDiameter
	def sourceValue = measurments.source
	def wheelDiameterValue = measurments.wheelDiameter
	for(String key:measurments.keySet().stream().sorted().collect(Collectors.toList())){
		//println "omniWheelRoller value "+key+" "+measurments.get(key);
	}
	// Stub of a CAD object
	CSG part = new Cylinder(rollerthickDiameterValue/2, rollerHeightValue).toCSG()
				.moveToCenterZ()
				.setColor(javafx.scene.paint.Color.WHITE)
	return part
		.setParameter(size)
		.setRegenerate({generate()})
}
return generate() 