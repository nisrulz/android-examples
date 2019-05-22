package sample.github.nisrulz.usingretrofit2.list;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import sample.github.nisrulz.usingretrofit2.R;
import sample.github.nisrulz.usingretrofit2.model.People;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.PeopleViewHolder> {
  private List<People> peoples;
  private int rowLayout;

  public static class PeopleViewHolder extends RecyclerView.ViewHolder {
    TextView name, gender, height, mass, eyecolor, haircolor, birthyear, skincolor;

    public PeopleViewHolder(View v) {
      super(v);
      name = (TextView) v.findViewById(R.id.textview_name);
      gender = (TextView) v.findViewById(R.id.textview_gender);
      eyecolor = (TextView) v.findViewById(R.id.textview_eyecolor);
      haircolor = (TextView) v.findViewById(R.id.textview_haircolor);
      skincolor = (TextView) v.findViewById(R.id.textview_skincolor);
      mass = (TextView) v.findViewById(R.id.textview_mass);
      height = (TextView) v.findViewById(R.id.textview_height);
      birthyear = (TextView) v.findViewById(R.id.textview_birthyear);
    }
  }

  public ListAdapter(List<People> peoples, int rowLayout) {
    this.peoples = peoples;
    this.rowLayout = rowLayout;
  }

  @Override public ListAdapter.PeopleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
    return new PeopleViewHolder(view);
  }

  @Override public void onBindViewHolder(PeopleViewHolder holder, final int position) {
    holder.name.setText(peoples.get(position).getName());
    holder.mass.setText("Mass : "+peoples.get(position).getMass());
    holder.gender.setText("Gender : "+peoples.get(position).getGender());
    holder.height.setText("Height : "+peoples.get(position).getHeight());
    holder.eyecolor.setText("Eye Color : "+peoples.get(position).getEyeColor());
    holder.skincolor.setText("Skin Color : "+peoples.get(position).getSkinColor());
    holder.haircolor.setText("Hair Color : "+peoples.get(position).getHairColor());
    holder.birthyear.setText("Birth Year : "+peoples.get(position).getBirthYear());
  }

  @Override public int getItemCount() {
    return peoples.size();
  }
}
