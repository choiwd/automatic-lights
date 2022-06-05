package se

import io.grpc.CallOptions
import io.grpc.CallOptions.DEFAULT
import io.grpc.Channel
import io.grpc.Metadata
import io.grpc.MethodDescriptor
import io.grpc.ServerServiceDefinition
import io.grpc.ServerServiceDefinition.builder
import io.grpc.ServiceDescriptor
import io.grpc.Status
import io.grpc.Status.UNIMPLEMENTED
import io.grpc.StatusException
import io.grpc.kotlin.AbstractCoroutineServerImpl
import io.grpc.kotlin.AbstractCoroutineStub
import io.grpc.kotlin.ClientCalls
import io.grpc.kotlin.ClientCalls.unaryRpc
import io.grpc.kotlin.ServerCalls
import io.grpc.kotlin.ServerCalls.unaryServerMethodDefinition
import io.grpc.kotlin.StubFor
import kotlin.String
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.jvm.JvmOverloads
import kotlin.jvm.JvmStatic
import se.AutomaticLightsGrpc.getServiceDescriptor

/**
 * Holder for Kotlin coroutine-based client and server APIs for autoLights.AutomaticLights.
 */
object AutomaticLightsGrpcKt {
  const val SERVICE_NAME: String = AutomaticLightsGrpc.SERVICE_NAME

  @JvmStatic
  val serviceDescriptor: ServiceDescriptor
    get() = AutomaticLightsGrpc.getServiceDescriptor()

  val turnOnOffMethod: MethodDescriptor<requestMessage, requestMessage>
    @JvmStatic
    get() = AutomaticLightsGrpc.getTurnOnOffMethod()

  val statusMethod: MethodDescriptor<queryMessage, queryMessage>
    @JvmStatic
    get() = AutomaticLightsGrpc.getStatusMethod()

  /**
   * A stub for issuing RPCs to a(n) autoLights.AutomaticLights service as suspending coroutines.
   */
  @StubFor(AutomaticLightsGrpc::class)
  class AutomaticLightsCoroutineStub @JvmOverloads constructor(
    channel: Channel,
    callOptions: CallOptions = DEFAULT
  ) : AbstractCoroutineStub<AutomaticLightsCoroutineStub>(channel, callOptions) {
    override fun build(channel: Channel, callOptions: CallOptions): AutomaticLightsCoroutineStub =
        AutomaticLightsCoroutineStub(channel, callOptions)

    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    suspend fun turnOnOff(request: requestMessage, headers: Metadata = Metadata()): requestMessage =
        unaryRpc(
      channel,
      AutomaticLightsGrpc.getTurnOnOffMethod(),
      request,
      callOptions,
      headers
    )
    /**
     * Executes this RPC and returns the response message, suspending until the RPC completes
     * with [`Status.OK`][Status].  If the RPC completes with another status, a corresponding
     * [StatusException] is thrown.  If this coroutine is cancelled, the RPC is also cancelled
     * with the corresponding exception as a cause.
     *
     * @param request The request message to send to the server.
     *
     * @param headers Metadata to attach to the request.  Most users will not need this.
     *
     * @return The single response from the server.
     */
    suspend fun status(request: queryMessage, headers: Metadata = Metadata()): queryMessage =
        unaryRpc(
      channel,
      AutomaticLightsGrpc.getStatusMethod(),
      request,
      callOptions,
      headers
    )}

  /**
   * Skeletal implementation of the autoLights.AutomaticLights service based on Kotlin coroutines.
   */
  abstract class AutomaticLightsCoroutineImplBase(
    coroutineContext: CoroutineContext = EmptyCoroutineContext
  ) : AbstractCoroutineServerImpl(coroutineContext) {
    /**
     * Returns the response to an RPC for autoLights.AutomaticLights.TurnOnOff.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open suspend fun turnOnOff(request: requestMessage): requestMessage = throw
        StatusException(UNIMPLEMENTED.withDescription("Method autoLights.AutomaticLights.TurnOnOff is unimplemented"))

    /**
     * Returns the response to an RPC for autoLights.AutomaticLights.status.
     *
     * If this method fails with a [StatusException], the RPC will fail with the corresponding
     * [Status].  If this method fails with a [java.util.concurrent.CancellationException], the RPC
     * will fail
     * with status `Status.CANCELLED`.  If this method fails for any other reason, the RPC will
     * fail with `Status.UNKNOWN` with the exception as a cause.
     *
     * @param request The request from the client.
     */
    open suspend fun status(request: queryMessage): queryMessage = throw
        StatusException(UNIMPLEMENTED.withDescription("Method autoLights.AutomaticLights.status is unimplemented"))

    final override fun bindService(): ServerServiceDefinition = builder(getServiceDescriptor())
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = AutomaticLightsGrpc.getTurnOnOffMethod(),
      implementation = ::turnOnOff
    ))
      .addMethod(unaryServerMethodDefinition(
      context = this.context,
      descriptor = AutomaticLightsGrpc.getStatusMethod(),
      implementation = ::status
    )).build()
  }
}
