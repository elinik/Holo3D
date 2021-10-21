package uni.ruse.holo3d;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;
//draw cylinder
public class Cylinder {
	
	private FloatBuffer mFVertexBuffer;
	private ByteBuffer mCircleBottom;
	private ByteBuffer mCircleTop;
	private ByteBuffer mEdge;
	private int numOfVertex;
	private float height =  0.8f;
	private float radious = 0.8f;
	int i;
	int n = 25;

	public Cylinder() {

		this.numOfVertex = n;

		float[] vertex = new float[3 * (n + 1) * 2];
		byte[] baseIndex = new byte[n];
		byte[] topIndex = new byte[n];
		byte[] edgeIndex = new byte[n * 2 + 2];

		double perAngle = 2 * Math.PI / n;

		for (i = 0; i < n; i++) {
			double angle = i * perAngle;
			int offset = 6 * i;

			vertex[offset + 0] = (float) (Math.cos(angle) * radious);
			vertex[offset + 1] = height;
			vertex[offset + 2] = (float) (Math.sin(angle) * radious);

			vertex[offset + 3] = (float) (Math.cos(angle) * radious);
			vertex[offset + 4] = -height;
			vertex[offset + 5] = (float) (Math.sin(angle) * radious);

			topIndex[i] = (byte) (2 * i);
			baseIndex[i] = (byte) (2 * i + 1);

			edgeIndex[2 * i] = topIndex[i];
			edgeIndex[2 * i + 1] = baseIndex[i];

		}

		edgeIndex[2 * n] = topIndex[0];
		edgeIndex[2 * n + 1] = baseIndex[0];

		ByteBuffer vbb = ByteBuffer.allocateDirect(vertex.length * 6);
		vbb.order(ByteOrder.nativeOrder());

		mFVertexBuffer = vbb.asFloatBuffer();
		mFVertexBuffer.put(vertex);
		mFVertexBuffer.position(0);

		mCircleBottom = ByteBuffer.allocateDirect(baseIndex.length);
		mCircleBottom.put(baseIndex);
		mCircleBottom.position(0);

		mCircleTop = ByteBuffer.allocateDirect(topIndex.length);
		mCircleTop.put(topIndex);
		mCircleTop.position(0);

		mEdge = ByteBuffer.allocateDirect(edgeIndex.length);
		mEdge.put(edgeIndex);
		mEdge.position(0);
	}

	public void draw(GL10 gl) {

		gl.glCullFace(GL10.GL_BACK);
		gl.glEnable(GL10.GL_CULL_FACE);

		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, mFVertexBuffer);
		gl.glNormalPointer(GL10.GL_FLOAT, 0, mFVertexBuffer);
		gl.glDrawArrays(GL10.GL_LINE_STRIP, 0, n);
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		
		gl.glPushMatrix();
		gl.glDrawElements(GL10.GL_LINE_LOOP, numOfVertex* 2 + 2,
				GL10.GL_UNSIGNED_BYTE, mEdge);
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glDrawElements(GL10.GL_LINE_LOOP, numOfVertex,
				GL10.GL_UNSIGNED_BYTE, mCircleTop);
		gl.glPopMatrix();

		gl.glPushMatrix();
		gl.glDrawElements(GL10.GL_LINE_LOOP, numOfVertex,
				GL10.GL_UNSIGNED_BYTE, mCircleBottom);
		gl.glPopMatrix();

	}


}
