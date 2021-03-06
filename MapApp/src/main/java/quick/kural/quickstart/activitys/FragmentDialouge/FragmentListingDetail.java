package quick.kural.quickstart.activitys.FragmentDialouge;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.OnClick;
import quick.kural.quickstart.R;


public class FragmentListingDetail extends DialogFragment {

    int mNum;
    String title;
    FrgamentInterface frgamentInterface;



    public static FragmentListingDetail newInstance(String title, int verifyType) {
        FragmentListingDetail f = new FragmentListingDetail();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putString("title", title);
        f.setArguments(args);

        return f;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentListingDetail.FrgamentInterface) {
            frgamentInterface = (FragmentListingDetail.FrgamentInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FrgamentInterface");
        }
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        title = getArguments().getString("title");



     /*   // Pick a style based on the num.
        int style = DialogFragment.STYLE_NORMAL, theme = 0;
        switch ((mNum-1)%6) {
            case 1: style = DialogFragment.STYLE_NO_TITLE; break;
            case 2: style = DialogFragment.STYLE_NO_FRAME; break;
            case 3: style = DialogFragment.STYLE_NO_INPUT; break;
            case 4: style = DialogFragment.STYLE_NORMAL; break;
            case 5: style = DialogFragment.STYLE_NORMAL; break;
            case 6: style = DialogFragment.STYLE_NO_TITLE; break;
            case 7: style = DialogFragment.STYLE_NO_FRAME; break;
            case 8: style = DialogFragment.STYLE_NORMAL; break;
        }
        switch ((mNum-1)%6) {
            case 4: theme = android.R.style.Theme_Holo; break;
            case 5: theme = android.R.style.Theme_Holo_Light_Dialog; break;
            case 6: theme = android.R.style.Theme_Holo_Light; break;
            case 7: theme = android.R.style.Theme_Holo_Light_Panel; break;
            case 8: theme = android.R.style.Theme_Holo_Light; break;
        }
        setStyle(style, theme);*/

        setStyle(DialogFragment.STYLE_NO_FRAME,  R.style.PopUpDialog);




    }


    @OnClick(R.id.tb_normal_back)
    void dismiss_Dialouge(){
        this.dismiss();
    }


    @Override
    public View onCreateView(LayoutInflater inflater,
           ViewGroup container,Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.dialog_pop_up, container, false);
        ButterKnife.bind(this,v);
        TextView textViewTitle = v.findViewById(R.id.tb_normal_title);
        textViewTitle.setText(title);

        return v;
    }



    public interface FrgamentInterface{

    void btn_on_fragamnet_item(Boolean accepted);

    }

}
