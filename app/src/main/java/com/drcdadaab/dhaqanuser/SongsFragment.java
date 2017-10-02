package com.drcdadaab.dhaqanuser;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


/**
 * A simple {@link Fragment} subclass.
 */
public class SongsFragment extends Fragment {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String CATEGORY_SONG = "Song";
    RecyclerView rv;
    LinearLayoutManager linearLayoutManager;
    DatabaseReference db;
    //    FirebaseAuth mAuth;
    FirebaseRecyclerAdapter<Article, ArticleViewHolder> firebasenewsRecycleAdapter;
    ProgressBar progressBarSongList;


    public SongsFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_songs, container, false);
        //Initialize Firebase DB
        db = FirebaseDatabase.getInstance().getReference();


        //SETUP RECYCLER
        rv = (RecyclerView) rootView.findViewById(R.id.recyclerViewSongList);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setStackFromEnd(false);


        progressBarSongList = (ProgressBar) rootView.findViewById(R.id.progressBarSongList);
        progressBarSongList.setVisibility(View.VISIBLE);

        Query query = db.child("Articles").orderByChild("category").equalTo(CATEGORY_SONG);

        firebasenewsRecycleAdapter = new FirebaseRecyclerAdapter<Article, ArticleViewHolder>(Article.class, R.layout.article_item_list, ArticleViewHolder.class, query) {
            @Override
            protected void populateViewHolder(ArticleViewHolder viewHolder, final Article model, final int position) {
                viewHolder.textViewListArticleTitle.setText(model.getTitle());
//                viewHolder.textViewListArticleCategory.setText(model.getCategory());
                viewHolder.textViewListArticleAuthor.setText(model.getAuthor());
                progressBarSongList.setVisibility(View.GONE);
                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        openDetailActivity(model.getId(), model.getTitle(), model.getCategory(), model.getAuthor(), model.getContent());
                    }
                });
            }

            private void openDetailActivity(String id, String title, String category, String author, String content) {
                Intent articleIntent = new Intent(getActivity(),  DetailActivity.class);
                articleIntent.putExtra("idKey", id);
                articleIntent.putExtra("titleKey", title);
                articleIntent.putExtra("categoryKey", category);
                articleIntent.putExtra("authorKey", author);
                articleIntent.putExtra("contentKey", content);
                startActivity(articleIntent);
            }
        };
        rv.setLayoutManager(linearLayoutManager);
        rv.setAdapter(firebasenewsRecycleAdapter);
        return rootView;
    }

}