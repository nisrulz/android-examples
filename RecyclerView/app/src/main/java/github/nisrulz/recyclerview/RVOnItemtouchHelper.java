package github.nisrulz.recyclerview;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ItemTouchHelper;

public class RVOnItemtouchHelper extends ItemTouchHelper.SimpleCallback {
    private RVAdapter rvAdapter;

    public RVOnItemtouchHelper(RVAdapter rvAdapter) {
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.rvAdapter = rvAdapter;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder dragged, RecyclerView.ViewHolder target) {
        rvAdapter.swap(dragged.getAdapterPosition(), target.getAdapterPosition());
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder swipped, int direction) {
        switch (direction) {
            case ItemTouchHelper.LEFT:
                //Remove item
                rvAdapter.remove(swipped.getAdapterPosition());
                System.out.println("Swipped Left");
                break;
            case ItemTouchHelper.RIGHT:
                rvAdapter.remove(swipped.getAdapterPosition());
                System.out.println("Swipped Right");
                break;
        }
    }
}