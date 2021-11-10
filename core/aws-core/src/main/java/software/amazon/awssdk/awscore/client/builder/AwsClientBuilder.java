/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package software.amazon.awssdk.awscore.client.builder;

import software.amazon.awssdk.annotations.SdkPublicApi;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.core.client.builder.SdkClientBuilder;
import software.amazon.awssdk.regions.Region;

/**
 * This includes required and optional override configuration required by every client builder. An instance can be acquired by
 * calling the static "builder" method on the type of client you wish to create.
 *
 * <p>Implementations of this interface are mutable and not thread-safe.</p>
 *
 * @param <BuilderT> The type of builder that should be returned by the fluent builder methods in this interface.
 * @param <ClientT> The type of client generated by this builder.
 */
@SdkPublicApi
public interface AwsClientBuilder<BuilderT extends AwsClientBuilder<BuilderT, ClientT>, ClientT>
    extends SdkClientBuilder<BuilderT, ClientT> {

    /**
     * Configure the credentials that should be used to authenticate with AWS.
     *
     * <p>The default provider will attempt to identify the credentials automatically using the following checks:
     * <ol>
     *   <li>Java System Properties - <code>aws.accessKeyId</code> and <code>aws.secretKey</code></li>
     *   <li>Environment Variables - <code>AWS_ACCESS_KEY_ID</code> and <code>AWS_SECRET_ACCESS_KEY</code></li>
     *   <li>Credential profiles file at the default location (~/.aws/credentials) shared by all AWS SDKs and the AWS CLI</li>
     *   <li>Credentials delivered through the Amazon EC2 container service if AWS_CONTAINER_CREDENTIALS_RELATIVE_URI environment
     *   variable is set and security manager has permission to access the variable.</li>
     *   <li>Instance profile credentials delivered through the Amazon EC2 metadata service</li>
     * </ol>
     *
     * <p>If the credentials are not found in any of the locations above, an exception will be thrown at {@link #build()} time.
     * </p>
     */
    BuilderT credentialsProvider(AwsCredentialsProvider credentialsProvider);

    /**
     * Configure the region with which the SDK should communicate.
     *
     * <p>If this is not specified, the SDK will attempt to identify the endpoint automatically using the following logic:
     * <ol>
     *     <li>Check the 'aws.region' system property for the region.</li>
     *     <li>Check the 'AWS_REGION' environment variable for the region.</li>
     *     <li>Check the {user.home}/.aws/credentials and {user.home}/.aws/config files for the region.</li>
     *     <li>If running in EC2, check the EC2 metadata service for the region.</li>
     * </ol>
     *
     * <p>If the region is not found in any of the locations above, an exception will be thrown at {@link #build()} time.
     */
    BuilderT region(Region region);

    /**
     * Configure whether the SDK should use the AWS dualstack endpoint.
     *
     * <p>If this is not specified, the SDK will attempt to determine whether the dualstack endpoint should be used
     * automatically using the following logic:
     * <ol>
     *     <li>Check the 'aws.useDualstackEndpoint' system property for 'true' or 'false'.</li>
     *     <li>Check the 'AWS_USE_DUALSTACK_ENDPOINT' environment variable for 'true' or 'false'.</li>
     *     <li>Check the {user.home}/.aws/credentials and {user.home}/.aws/config files for the 'use_dualstack_endpoint'
     *     property set to 'true' or 'false'.</li>
     * </ol>
     *
     * <p>If the setting is not found in any of the locations above, 'false' will be used.
     */
    BuilderT dualstackEnabled(Boolean dualstackEndpointEnabled);

    /**
     * Configure whether the SDK should use the AWS fips endpoints.
     *
     * <p>If this is not specified, the SDK will attempt to determine whether the fips endpoint should be used
     * automatically using the following logic:
     * <ol>
     *     <li>Check the 'aws.useFipsEndpoint' system property for 'true' or 'false'.</li>
     *     <li>Check the 'AWS_USE_FIPS_ENDPOINT' environment variable for 'true' or 'false'.</li>
     *     <li>Check the {user.home}/.aws/credentials and {user.home}/.aws/config files for the 'use_fips_endpoint'
     *     property set to 'true' or 'false'.</li>
     * </ol>
     *
     * <p>If the setting is not found in any of the locations above, 'false' will be used.
     */
    BuilderT fipsEnabled(Boolean fipsEndpointEnabled);
}
