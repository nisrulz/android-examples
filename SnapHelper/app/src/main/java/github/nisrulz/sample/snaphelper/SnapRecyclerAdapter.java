package github.nisrulz.sample.snaphelper;

import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class SnapRecyclerAdapter extends RecyclerView.Adapter<SnapRecyclerAdapter.ViewHolder> {

  private List<Item> list;
  // Store the context for easy access
  private Context mContext;

  public SnapRecyclerAdapter(List<Item> list, Context mContext) {
    this.list = list;
    this.mContext = mContext;
  }

  // Easy access to the context object in the recyclerview
  private Context getContext() {
    return mContext;
  }

  @Override
  public SnapRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    Context context = parent.getContext();
    LayoutInflater inflater = LayoutInflater.from(context);

    // Inflate the custom layout
    View contactView = inflater.inflate(R.layout.list_item, parent, false);

    // Return a new holder instance
    ViewHolder viewHolder = new ViewHolder(contactView);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    // Get the data model based on position
    Item item = list.get(position);

    // Set item views based on your views and data model
    TextView textView = holder.nameTextView;
    textView.setText(item.getName());
    ImageView imgview= holder.imageView;
    imgview.setImageDrawable(ContextCompat.getDrawable(mContext,item.getImgRes()));
  }

  @Override
  public int getItemCount() {
    return list.size();
  }

  // Provide a direct reference to each of the views within a data item
  // Used to cache the views within the item layout for fast access
  public static class ViewHolder extends RecyclerView.ViewHolder {
    // Your holder should contain a member variable
    // for any view that will be set as you render a row
    public TextView nameTextView;
    public ImageView imageView;

    // We also create a constructor that accepts the entire item row
    // and does the view lookups to find each subview
    public ViewHolder(View itemView) {
      // Stores the itemView in a public final member variable that can be used
      // to access the context from any ViewHolder instance.
      super(itemView);

      nameTextView = (TextView) itemView.findViewById(R.id.name);
      imageView = (ImageView) itemView.findViewById(R.id.imgView);
    }
  }
}
