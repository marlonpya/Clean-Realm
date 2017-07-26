package adexus.innova.gmd.com.pe.cleanrealm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import adexus.innova.gmd.com.pe.cleanrealm.adapter.UserAdapter;
import adexus.innova.gmd.com.pe.cleanrealm.db.manager.IManager;
import adexus.innova.gmd.com.pe.cleanrealm.db.manager.UserManager;
import adexus.innova.gmd.com.pe.cleanrealm.db.sql.UserSql;
import adexus.innova.gmd.com.pe.cleanrealm.mapper.UserSqlToUserEntityMapper;
import adexus.innova.gmd.com.pe.cleanrealm.model.UserEntity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.txtName) EditText txtName;
    @BindView(R.id.txtLastName) EditText txtLastName;
    @BindView(R.id.txtAge) EditText txtAge;
    @BindView(R.id.lvExample) ListView listView;
    private IManager iManager;
    private UserAdapter adapter;
    private List<UserEntity> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
        ui();
    }

    private void initView() {
        iManager = new UserManager();
        users = iManager.getList();
        adapter = new UserAdapter(this, users);
    }

    private void ui() {
        listView.setAdapter(adapter);
    }

    @OnClick(R.id.btnAdd)
    public void add() {
        String name = getContent(txtName);
        String lastName = getContent(txtLastName);
        String age = getContent(txtAge);
        if (!name.isEmpty() || !lastName.isEmpty() || !age.isEmpty()) {
            UserSql userSql = new UserSql();
            userSql.setId(iManager.lastId());
            userSql.setName(name);
            userSql.setLastName(lastName);
            userSql.setAge(Integer.parseInt(age));
            iManager.createOrUpdate(userSql);
            UserEntity userEntity = UserSqlToUserEntityMapper.getInstance().reverseMap(userSql);
            adapter.add(userEntity);
        }
    }

    @Override
    protected void onDestroy() {
        iManager.close();
        super.onDestroy();
    }

    private String getContent(EditText editText) {
        return editText.getText().toString();
    }
}
