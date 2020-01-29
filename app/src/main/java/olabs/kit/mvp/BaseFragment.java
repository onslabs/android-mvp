package olabs.kit.mvp;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;


public class BaseFragment<T extends BasePresenter, S extends ViewDataBinding> extends Fragment {



    @Nullable
    protected T mPresenter;

    @Nullable
    protected S mViewDataBinding;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public BaseFragment() {
        // Required empty public constructor
    }

    protected void init(T t, S s) {
        this.mPresenter = t;
        this.mViewDataBinding = s;

    }


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }


    public void onDetach() {
        super.onDetach();
    }


    protected boolean isOnline() {
        if (getActivity() != null) {
            ConnectivityManager cm =
                    (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            return netInfo != null && netInfo.isConnectedOrConnecting();
        } else {
            return false;
        }
    }

    protected void setToolbarTitle(String title) {
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setTitle(title);
    }
}
