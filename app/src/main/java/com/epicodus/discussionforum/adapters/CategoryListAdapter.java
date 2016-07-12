package com.epicodus.discussionforum.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.discussionforum.R;
import com.epicodus.discussionforum.models.Category;
import com.epicodus.discussionforum.ui.CategoryQuestionsActivity;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 7/11/16.
 */
public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder> {
    private ArrayList<Category> mCategories = new ArrayList<>();
    private Context mContext;

    public CategoryListAdapter(Context context, ArrayList<Category> categories) {
        mContext = context;
        mCategories = categories;
    }

    @Override
    public CategoryListAdapter.CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list_item, parent, false);
        CategoryViewHolder viewHolder = new CategoryViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CategoryListAdapter.CategoryViewHolder holder, int position) {
        holder.bindCategory(mCategories.get(position));
    }

    @Override
    public int getItemCount() {
        return mCategories.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder /*implements View.OnClickListener*/ {
        @Bind(R.id.titleTextView) TextView mTitleTextView;

        //Commented code is not necessary after implementing firebase, i think
//        private Context mContext;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
//            mContext = itemView.getContext();
//            itemView.setOnClickListener(this);
        }

        public void bindCategory (Category category) {
            mTitleTextView.setText(category.getTitle());
        }

//        @Override
//        public void onClick (View view) {
//            Log.d("list adapter", "click");
//            Intent intent = new Intent(mContext, CategoryQuestionsActivity.class);
//            mContext.startActivity(intent);
//        }
    }
}
