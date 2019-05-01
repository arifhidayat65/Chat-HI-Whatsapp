package men.ngopi.zain.hiwa;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kelin.translucentbar.library.TranslucentBarManager;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MoreFragment extends Fragment {

    private View view;
    static private MoreFragment moreFragment;

    public static MoreFragment newInstance(){
        moreFragment = new MoreFragment();
        return moreFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_more, container, false);

        TranslucentBarManager translucentBarManager = new TranslucentBarManager(this);
        translucentBarManager.translucent( this, view, R.color.colorAccent);

        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @OnClick({R.id.btn_rate_app})
    public void btnOnClick(View v){
        switch (v.getId()){
            case R.id.btn_rate_app:
                final String appPackageName = getActivity().getPackageName();// getPackageName() from Context or Activity object
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                }
                catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                }
                break;
        }
    }
}
