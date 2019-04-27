package app.n1ru20.com.dbviewpager;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {



    //adapter class for recycler view
    Context mcontext;
    List<Profile> mdata;
    private Dialog mydialog;

    public CustomAdapter(Context mcontext, List<Profile> mdata) {
        this.mcontext = mcontext;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v=LayoutInflater.from(mcontext).inflate(R.layout.custom_layout,viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {

        //adding onclick dialog to images
        final int pos = i;
        mydialog = new Dialog(mcontext);
        mydialog.setContentView(R.layout.dialog_layout);
        myViewHolder.txtview.setText(mdata.get(i).getText1());
        Picasso.get().load(mdata.get(i).getImage1()).fit().centerCrop().into(myViewHolder.imgview);
        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView dialogtext= mydialog.findViewById(R.id.textviewdialog);
                ImageView dialogimage=mydialog.findViewById(R.id.imageviewdialog);
                dialogtext.setText(myViewHolder.txtview.getText());
                Picasso.get().load(mdata.get(pos).getImage1()).fit().centerCrop().into(dialogimage);
                mydialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtview;
        ImageView imgview;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtview=itemView.findViewById(R.id.cardtextview);
            imgview=itemView.findViewById(R.id.vwimg);
            cardView= itemView.findViewById(R.id.cardviewrc);
        }
    }
}
