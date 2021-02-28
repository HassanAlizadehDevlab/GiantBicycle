package com.android.giantbicycle.login.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.android.giantbicycle.databinding.ActivityLoginBinding
import com.android.shared.presentation.ViewModelProviderFactory
import com.google.android.material.snackbar.Snackbar
import dagger.android.AndroidInjection
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    @Inject
    lateinit var factory: ViewModelProviderFactory
    private lateinit var viewModel: LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        inject()
        setupObservers()
        setupClickListeners()
    }

    private fun inject() {
        AndroidInjection.inject(this)
    }

    private fun setupObservers() {
        viewModel = ViewModelProvider(this, factory)[LoginViewModel::class.java]

        viewModel.messageObservable.observe(this, ::observeMessages)
        viewModel.response.observe(this, ::observeResponse)
        viewModel.isRefreshing.observe(this, ::observeLoading)
        viewModel.isRefreshing.observe(this, ::observeLoginButton)
    }

    private fun setupClickListeners() {
        with(binding) {

            buttonLogin.setOnClickListener {
                val username = editTextUsername.text?.let { it.toString() }
                val password = editTextPassword.text?.let { it.toString() }
                viewModel.login(username, password)
            }
        }
    }

    private fun observeLoading(isLoading: Boolean) {
        binding.loading.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun observeLoginButton(isLoading: Boolean) {
        binding.buttonLogin.isEnabled = !isLoading
    }

    private fun observeResponse(result: Int) {
        Snackbar.make(binding.root, "Result is $result", Snackbar.LENGTH_LONG).show()
    }

    private fun observeMessages(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
    }


}