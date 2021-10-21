package uni.ruse.holo3d;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLU;
import android.opengl.GLSurfaceView.Renderer;

public class OpenGLRendererCubeBlue implements Renderer {

	private Cube mCube = new Cube();
	private float mCubeRotation;
	
	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f);
		  
		gl.glClearDepthf(1.0f);
		gl.glEnable(GL10.GL_DEPTH_TEST);
		gl.glDepthFunc(GL10.GL_LEQUAL);

		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);

	}

	@Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);        
       gl.glLoadIdentity();
       gl.glLineWidth(1.5f);
       gl.glColor4f(0.0f, 0.0f,1.0f, 1.0f); //blue
       //top
        gl.glTranslatef(0.5f,3.0f, -10.0f);
        gl.glRotatef(mCubeRotation, 1.0f, 1.0f, 1.0f);  
        mCube.draw(gl);
        gl.glLoadIdentity();
        
        //
        gl.glTranslatef(0.5f, -1.0f, -10.0f);
       // gl.glRotatef(180.0f, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(mCubeRotation, -1.0f, -1.0f, -1.0f);
        mCube.draw(gl);
        gl.glLoadIdentity();
        
        
        gl.glTranslatef(-1.5f, 1.0f, -10.0f);
        //gl.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(mCubeRotation, 1.0f, 1.0f, 1.0f);
        mCube.draw(gl); 
        gl.glLoadIdentity();
        
        
        gl.glTranslatef(2.5f, 1.0f, -10.0f);
       // gl.glRotatef(270.0f, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(mCubeRotation, -1.0f, -1.0f,-1.0f);
        mCube.draw(gl);   
        gl.glLoadIdentity();                                    
            
        mCubeRotation -= 0.65f; 
    }

   



	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		gl.glViewport(0, 0, width, height);
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();

		float fovy = 50.0f; // Field of view angle, in degrees, in the Y
							// direction.
		float aspect = (float) width / (float) height;
		float zNear = 0.1f;
		float zFar = 100.0f;
		// Set up a perspective projection matrix
		GLU.gluPerspective(gl, fovy, aspect, zNear, zFar);

		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
	}


}