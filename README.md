App Delivery - Programação Aplicativos Mobile.

<?xml version="1.0" encoding="utf-8"?>

<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/main"
    android:orientation="vertical"
    android:background="#333232"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_margin="50dp"
        android:text="Login"
        android:textColor="@color/white"
        android:textSize="24sp"
        android:textStyle="bold" />

    <EditText android:id="@+id/edt_nome"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginStart="20dp"
        android:layout_marginEnd="20dp"
        android:padding="15dp"
        android:background="@drawable/borda"
        android:hint="Informe o nome" />

    <EditText android:id="@+id/edt_email"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginStart="20dp"
        android:layout_marginEnd="20dp"
        android:layout_marginTop="20dp"
        android:padding="15dp"
        android:background="@drawable/borda"
        android:hint="Informe o email" />

    <EditText android:id="@+id/edt_senha"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginStart="20dp"
        android:layout_marginEnd="20dp"
        android:layout_marginTop="20dp"
        android:padding="15dp"
        android:background="@drawable/borda"
        android:hint="Informe a senha"
        android:inputType="textPassword" />
    
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <Button android:id="@+id/btn_entrar"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:layout_marginStart="20dp"
            android:layout_marginTop="20dp"
            android:layout_marginEnd="10dp"
            android:padding="15dp"
            android:text="ENTRAR"
            android:backgroundTint="#F44336" />

        <Button android:id="@+id/btn_novo"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:layout_marginStart="10dp"
            android:layout_marginTop="20dp"
            android:layout_marginEnd="20dp"
            android:padding="15dp"
            android:text="NOVO USUÁRIO"
            android:backgroundTint="#706A6A" />

    </LinearLayout>

    <CheckBox android:id="@+id/checkBox"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginStart="20dp"
        android:layout_marginTop="10dp"
        android:text="Lembrar minhas Credenciais"
        android:textColor="@color/white"
        android:buttonTint="@color/white" />

</LinearLayout>
