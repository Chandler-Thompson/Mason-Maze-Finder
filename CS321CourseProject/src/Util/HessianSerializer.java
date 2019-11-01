package Util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.SerializerFactory;

/**
 * Implements Hessian-protocol based serialization.
 * See <a href="http://hessian.caucho.com/">this</a> (the Hessian website) for more details.
 *
 */
public class HessianSerializer {

	/**
	 * Factory for returning serialization methods.
	 * See the <a href="http://javadoc4.caucho.com/com/caucho/hessian/io/SerializerFactory.html">docs</a>.
	 */
	private static SerializerFactory serializerFactory = new SerializerFactory();
	
	// Reference: https://gist.github.com/vongosling/10353488
	public static Serializable deserialize(byte[] serializedObj) throws IOException {
		Object deserializedObject = null;
		
		// A ByteArrayInputStream contains an internal buffer that contains bytes that may be read from the stream.
		ByteArrayInputStream inputStream = new ByteArrayInputStream(serializedObj);
		
		// This object provides a reader for the Hessian 2.0 protocol, which we are using when we serialize.
		Hessian2Input hessianInput = new Hessian2Input(inputStream);
		
		// Set the serializer factory (which provides serialization methods). We also want to close the stream once we're done.
		hessianInput.setSerializerFactory(serializerFactory);
		hessianInput.setCloseStreamOnClose(true);
		
		// Start the deserialization process.
		hessianInput.startMessage();
		
		// Parse the input stream and output a deserialized object.
		deserializedObject = hessianInput.readObject();
		
		// Close the hessian input object, which in turn closes the ByteArrayInputStream object.
		hessianInput.close();
		
		return (Serializable)deserializedObject;
	}
	
	public static byte[] serialize(Object obj) throws IOException {
		// Output stream in which the data is written into a byte array.
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		
		// Output stream for Hessian 2 requests.
		Hessian2Output hessianOutput = new Hessian2Output(outputStream);
		hessianOutput.setSerializerFactory(serializerFactory);
		hessianOutput.setCloseStreamOnClose(true);
		
		// Start the serialization process.
		hessianOutput.startMessage();
		
		// Serialize the object.
		hessianOutput.writeObject(obj);
		
		// Finish the process.
		hessianOutput.completeMessage();
		hessianOutput.close();
		
		// Return the byte array representation of our object.
		return outputStream.toByteArray();
	}
}
