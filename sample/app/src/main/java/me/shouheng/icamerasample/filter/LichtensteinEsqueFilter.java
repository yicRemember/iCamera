package me.shouheng.icamerasample.filter;

import android.content.Context;
import android.opengl.GLES20;

import me.shouheng.icamerasample.R;
import me.shouheng.icamerasample.render.MyGLUtils;

public class LichtensteinEsqueFilter extends CameraFilter {
    private int program;

    public LichtensteinEsqueFilter(Context context) {
        super(context);

        // Build shaders
        program = MyGLUtils.buildProgram(context, R.raw.vertext, R.raw.lichtenstein_esque);
    }

    @Override
    public void onDraw(int cameraTexId, int canvasWidth, int canvasHeight) {
        setupShaderInputs(program,
                new int[]{canvasWidth, canvasHeight},
                new int[]{cameraTexId},
                new int[][]{});
        GLES20.glDrawArrays(GLES20.GL_TRIANGLE_STRIP, 0, 4);
    }
}
