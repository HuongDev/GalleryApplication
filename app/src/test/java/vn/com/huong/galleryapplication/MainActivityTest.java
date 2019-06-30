package vn.com.huong.galleryapplication;

import androidx.recyclerview.widget.RecyclerView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import vn.com.huong.galleryapplication.main.MainActivity;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by HuongPN on 6/30/2019.
 */
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    private MainActivity mActivity;
    private RecyclerView rcvItems;

    @Before
    public void setUp() throws Exception {
        mActivity = Robolectric.buildActivity(MainActivity.class).create().get();
        rcvItems = mActivity.findViewById(R.id.rcvItems);
    }

    @Test
    public void testNotNull() throws Exception {
        assertNotNull(rcvItems);
        assertNotNull(mActivity);
    }
}
